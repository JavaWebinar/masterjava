package ru.javaops.masterjava.service.mail.rest;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class MailRestConfig extends ResourceConfig {
    public MailRestConfig() {
        packages("ru.javaops.masterjava.service.mail.rest");
    }
}