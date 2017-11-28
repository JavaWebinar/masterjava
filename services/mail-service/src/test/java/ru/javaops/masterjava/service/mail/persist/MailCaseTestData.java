package ru.javaops.masterjava.service.mail.persist;

import com.google.common.collect.ImmutableList;
import ru.javaops.masterjava.persist.DBIProvider;
import ru.javaops.masterjava.service.mail.Addressee;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class MailCaseTestData {
    private static final Instant now = Instant.now();
    static final Date DATE_FROM = Date.from(now.minus(Duration.ofDays(1)));

    static final List<MailCase> MAIL_CASES = ImmutableList.of(
            MailCase.of(
                    ImmutableList.of(
                            new Addressee("ИмяTo1 Фамилия1 <mailTo1@ya.ru>"),
                            new Addressee("Имя2 Фамилия2 <mailTo2@ya.ru>")),
                    ImmutableList.of(
                            new Addressee("ИмяCc1 Фамилия1 <mail1Cc@ya.ru>"),
                            new Addressee("ИмяCc2 Фамилия2 <mailCc2@ya.ru>")),
                    "subject1", "state1"
            ),
            new MailCase("toMail2@ya.ru", null, "subject2", "state2",
                    Date.from(now.minus(Duration.ofMinutes(1)))),
            new MailCase(null, "ccMail3@ya.ru", "subject3", "state3", DATE_FROM)
    );

    private static final MailCase MAIL_CASE_EXCLUDED =
            new MailCase("toMail4@ya.ru", "ccMail4@ya.ru", "subject4", "state4",
                    Date.from(now.minus(Duration.ofDays(2))));

    public static void setUp() {
        MailCaseDao dao = DBIProvider.getDao(MailCaseDao.class);
        dao.clean();
        DBIProvider.getDBI().useTransaction((conn, status) -> {
            MAIL_CASES.forEach(dao::insert);
            dao.insert(MAIL_CASE_EXCLUDED);
        });
    }
}