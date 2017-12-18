package ru.javaops.masterjava.service.mail.rest;


import org.hibernate.validator.constraints.NotBlank;
import ru.javaops.masterjava.service.mail.GroupResult;
import ru.javaops.masterjava.service.mail.MailServiceExecutor;
import ru.javaops.masterjava.service.mail.MailWSClient;
import ru.javaops.masterjava.web.WebStateException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collections;

@Path("/")
public class MailRS {
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Test";
    }

    @POST
    @Path("send")
    @Produces(MediaType.APPLICATION_JSON)
    public GroupResult send(@NotBlank @FormParam("users") String users,
                            @FormParam("subject") String subject,
                            @NotBlank @FormParam("body") String body) throws WebStateException {

        return MailServiceExecutor.sendBulk(MailWSClient.split(users), subject, body, Collections.emptyList());
    }
}