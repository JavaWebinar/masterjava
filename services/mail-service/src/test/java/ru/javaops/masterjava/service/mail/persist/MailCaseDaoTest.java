package ru.javaops.masterjava.service.mail.persist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javaops.masterjava.persist.dao.AbstractDaoTest;

public class MailCaseDaoTest extends AbstractDaoTest<MailCaseDao> {
    public MailCaseDaoTest() {
        super(MailCaseDao.class);
    }

    @Before
    public void setUp() throws Exception {
        MailCaseTestData.setUp();
    }

    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(MailCaseTestData.MAIL_CASES, dao.getAfter(MailCaseTestData.DATE_FROM));
    }
}