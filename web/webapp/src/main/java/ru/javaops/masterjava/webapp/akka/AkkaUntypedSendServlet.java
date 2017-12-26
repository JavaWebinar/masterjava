package ru.javaops.masterjava.webapp.akka;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import lombok.extern.slf4j.Slf4j;
import ru.javaops.masterjava.service.mail.GroupResult;
import ru.javaops.masterjava.service.mail.util.MailUtils.MailObject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.javaops.masterjava.webapp.WebUtil.createMailObject;
import static ru.javaops.masterjava.webapp.WebUtil.doAndWriteResponse;
import static ru.javaops.masterjava.webapp.akka.AkkaWebappListener.akkaActivator;

@WebServlet(value = "/sendAkkaUntyped", loadOnStartup = 1)
@Slf4j
@MultipartConfig
public class AkkaUntypedSendServlet extends HttpServlet {
    private ActorRef webappActor;
    private ActorRef mailActor;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        webappActor = akkaActivator.startActor(WebappActor.class, "mail-client");
        mailActor = akkaActivator.getActorRef("akka.tcp://MailService@127.0.0.1:2553/user/mail-actor");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        doAndWriteResponse(resp, () -> sendAkka(createMailObject(req)));
    }

    private String sendAkka(MailObject mailObject) {
        mailActor.tell(mailObject, webappActor);
        return "Successfully sent AKKA message";
    }

    public static class WebappActor extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder().match(GroupResult.class,
                    groupResult -> log.info(groupResult.toString()))
                    .build();
        }
    }
}