package ru.javaops.masterjava.persist.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.javaops.masterjava.persist.GroupTestData;
import ru.javaops.masterjava.persist.model.Group;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static ru.javaops.masterjava.persist.GroupTestData.GROUPS;

public class GroupDaoTest extends AbstractDaoTest<GroupDao> {

    public GroupDaoTest() {
        super(GroupDao.class);
    }

    @BeforeClass
    public static void init() throws Exception {
        GroupTestData.init();
    }

    @Before
    public void setUp() throws Exception {
        GroupTestData.setUp();
    }

    @Test
    public void getAll() throws Exception {
        final Map<String, Group> projects = dao.getAsMap();
        assertEquals(GROUPS, projects);
        System.out.println(projects.values());
    }
}