package ru.javaops.masterjava.service.mail;

import akka.dispatch.Futures;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;
import ru.javaops.masterjava.ExceptionType;
import ru.javaops.masterjava.service.mail.util.MailUtils;
import ru.javaops.masterjava.service.mail.util.MailUtils.MailObject;
import ru.javaops.masterjava.web.WebStateException;
import ru.javaops.masterjava.web.WsClient;
import scala.concurrent.ExecutionContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

@Slf4j
public class MailServiceExecutor {

    private static final String INTERRUPTED_BY_FAULTS_NUMBER = "+++ Interrupted by faults number";
    private static final String INTERRUPTED_BY_TIMEOUT = "+++ Interrupted by timeout";

    private static final ExecutorService mailExecutor = Executors.newFixedThreadPool(8);

    public static GroupResult sendBulk(final MailObject mailObject) throws WebStateException {
        return sendBulk(MailUtils.split(mailObject.getUsers()),
                mailObject.getSubject(), mailObject.getBody(), MailUtils.getAttachments(mailObject.getAttachments()));
    }

    public static GroupResult sendBulk(final Set<Addressee> addressees, final String subject, final String body, List<Attachment> attachments) throws WebStateException {
        final CompletionService<MailResult> completionService = new ExecutorCompletionService<>(mailExecutor);

        List<Future<MailResult>> futures = StreamEx.of(addressees)
                .map(addressee -> completionService.submit(() -> MailSender.sendTo(addressee, subject, body, attachments)))
                .toList();

        return new Callable<GroupResult>() {
            private int success = 0;
            private List<MailResult> failed = new ArrayList<>();

            @Override
            public GroupResult call() throws WebStateException {
                while (!futures.isEmpty()) {
                    try {
                        Future<MailResult> future = completionService.poll(10, TimeUnit.SECONDS);
                        if (future == null) {
                            cancel(INTERRUPTED_BY_TIMEOUT, null);
                        }
                        futures.remove(future);
                        MailResult mailResult = future.get();
                        if (mailResult.isOk()) {
                            success++;
                        } else {
                            failed.add(mailResult);
                            if (failed.size() >= 5) {
                                cancel(INTERRUPTED_BY_FAULTS_NUMBER, null);
                            }
                        }
                    } catch (ExecutionException e) {
                        cancel(null, e.getCause());
                    } catch (InterruptedException e) {
                        cancel(INTERRUPTED_BY_TIMEOUT, null);
                    }
                }
                GroupResult groupResult = new GroupResult(success, failed);
                log.info("groupResult: {}", groupResult);
                return groupResult;
            }

            private void cancel(String cause, Throwable t) throws WebStateException {
                futures.forEach(f -> f.cancel(true));
                if (cause != null) {
                    throw new WebStateException(cause, ExceptionType.EMAIL);
                } else {
                    throw WsClient.getWebStateException(t, ExceptionType.EMAIL);
                }
            }
        }.call();
    }

    public static scala.concurrent.Future<GroupResult> sendAsyncWithReply(MailObject mailObject, ExecutionContext ec) {
        // http://doc.akka.io/docs/akka/current/java/futures.html
        return Futures.future(() -> sendBulk(mailObject), ec);
    }

    public static void sendAsync(MailObject mailObject) {
        Set<Addressee> addressees = MailUtils.split(mailObject.getUsers());
        addressees.forEach(addressee ->
                mailExecutor.submit(() -> {
                    try {
                        MailSender.sendTo(addressee, mailObject.getSubject(), mailObject.getBody(),
                                MailUtils.getAttachments(mailObject.getAttachments()));
                    } catch (WebStateException e) {
                        // already logged
                    }
                })
        );
    }
}