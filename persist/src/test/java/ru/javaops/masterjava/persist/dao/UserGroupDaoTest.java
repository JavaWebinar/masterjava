package ru.javaops.masterjava.persist.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.javaops.masterjava.persist.UserGroupTestData;

import java.util.Set;

import static ru.javaops.masterjava.persist.GroupTestData.MASTERJAVA_01_ID;
import static ru.javaops.masterjava.persist.GroupTestData.TOPJAVA_07_ID;
import static ru.javaops.masterjava.persist.UserGroupTestData.getByGroupId;

public class UserGroupDaoTest extends AbstractDaoTest<UserGroupDao> {

    public UserGroupDaoTest() {
        super(UserGroupDao.class);
    }

    @BeforeClass
    public static void init() throws Exception {
        UserGroupTestData.init();
    }

    @Before
    public void setUp() throws Exception {
        UserGroupTestData.setUp();
    }

    @Test
    public void getAll() throws Exception {
        Set<Integer> userIds = dao.getUserIds(MASTERJAVA_01_ID);
        Assert.assertEquals(getByGroupId(MASTERJAVA_01_ID), userIds);

        userIds = dao.getUserIds(TOPJAVA_07_ID);
        Assert.assertEquals(getByGroupId(TOPJAVA_07_ID), userIds);
    }
}