package ru.javaops.masterjava.service.mail;

import ru.javaops.masterjava.web.handler.SoapServerSecurityHandler;

public class MailHandlers {
    public static class SecurityHandler extends SoapServerSecurityHandler {
        public SecurityHandler() {
            super(MailWSClient.USER, MailWSClient.PASSWORD);
        }
    }
}
