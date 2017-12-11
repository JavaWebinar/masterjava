package ru.javaops.masterjava.service.mail;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import lombok.extern.slf4j.Slf4j;
import ru.javaops.masterjava.web.WebStateException;

import javax.activation.DataHandler;
import java.io.File;
import java.net.MalformedURLException;

@Slf4j
public class MailWSClientMain {
    public static void main(String[] args) throws WebStateException, MalformedURLException {
        String state = MailWSClient.sendToGroup(
                ImmutableSet.of(new Addressee("To <masterjava@javaops.ru>")),
                ImmutableSet.of(new Addressee("Copy <masterjava@javaops.ru>")), "Subject", "Body",
                ImmutableList.of(new Attachment("version.html",
                        new DataHandler(new File("config_templates/version.html").toURI().toURL()))
                ));
        System.out.println(state);
    }
}