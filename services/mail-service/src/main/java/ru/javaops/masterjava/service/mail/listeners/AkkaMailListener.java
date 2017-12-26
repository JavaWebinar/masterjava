package ru.javaops.masterjava.service.mail.listeners;

import akka.actor.AbstractActor;
import akka.japi.Creator;
import lombok.extern.slf4j.Slf4j;
import ru.javaops.masterjava.akka.AkkaActivator;
import ru.javaops.masterjava.service.mail.GroupResult;
import ru.javaops.masterjava.service.mail.MailRemoteService;
import ru.javaops.masterjava.service.mail.MailServiceExecutor;
import ru.javaops.masterjava.service.mail.util.MailUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class AkkaMailListener implements ServletContextListener {
    private AkkaActivator akkaActivator;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        akkaActivator = AkkaActivator.start("MailService", "mail-service");
        akkaActivator.startTypedActor(MailRemoteService.class, "mail-remote-service",
                (Creator<MailRemoteService>) () ->
                        mailObject -> MailServiceExecutor.sendAsyncWithReply(mailObject, akkaActivator.getExecutionContext()));
        akkaActivator.startActor(MailActor.class, "mail-actor");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        akkaActivator.shutdown();
    }

    public static class MailActor extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder().match(MailUtils.MailObject.class,
                    mailObject -> {
                        log.info("Receive mail form webappActor");
                        GroupResult groupResult = MailServiceExecutor.sendBulk(mailObject);
                        log.info("Send result to webappActor");
                        sender().tell(groupResult, self());
                    })
                    .build();
        }
    }

}