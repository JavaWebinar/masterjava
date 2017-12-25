package ru.javaops.masterjava.service.mail.rest;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class MailRestConfig extends ResourceConfig {

    public MailRestConfig() {
        // Set Jersey log to SLF4J instead of JUL
        // http://stackoverflow.com/questions/4121722
        SLF4JBridgeHandler.install();
        packages("ru.javaops.masterjava.service.mail.rest");
        register(MultiPartFeature.class);
    }
}