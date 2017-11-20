package ru.javaops.masterjava.service.mail;

import javax.xml.ws.Endpoint;

/**
 * User: gkislin
 * Date: 28.05.2014
 */
public class MailServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/mail/mailService", new MailServiceImpl());
    }
}
