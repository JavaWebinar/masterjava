package ru.javaops.masterjava.service.mail;

import ru.javaops.masterjava.service.mail.util.MailUtils;

public interface MailRemoteService {

    scala.concurrent.Future<GroupResult> sendBulk(MailUtils.MailObject mailObject);
}