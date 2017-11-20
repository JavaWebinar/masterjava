package ru.javaops.masterjava.persist;

import com.google.common.collect.ImmutableMap;
import ru.javaops.masterjava.persist.dao.GroupDao;
import ru.javaops.masterjava.persist.model.Group;

import java.util.Map;

import static ru.javaops.masterjava.persist.ProjectTestData.MASTERJAVA_ID;
import static ru.javaops.masterjava.persist.ProjectTestData.TOPJAVA_ID;
import static ru.javaops.masterjava.persist.model.type.GroupType.CURRENT;
import static ru.javaops.masterjava.persist.model.type.GroupType.FINISHED;

public class GroupTestData {
    public static Group TOPJAVA_06;
    public static Group TOPJAVA_07;
    public static Group TOPJAVA_08;
    public static Group MASTERJAVA_01;
    public static Map<String, Group> GROUPS;

    public static int TOPJAVA_06_ID;
    public static int TOPJAVA_07_ID;
    public static int TOPJAVA_08_ID;
    public static int MASTERJAVA_01_ID;


    public static void init() {
        ProjectTestData.init();
        ProjectTestData.setUp();

        TOPJAVA_06 = new Group("topjava06", FINISHED, TOPJAVA_ID);
        TOPJAVA_07 = new Group("topjava07", FINISHED, TOPJAVA_ID);
        TOPJAVA_08 = new Group("topjava08", CURRENT, TOPJAVA_ID);
        MASTERJAVA_01 = new Group("masterjava01", CURRENT, MASTERJAVA_ID);
        GROUPS = ImmutableMap.of(
                TOPJAVA_06.getName(), TOPJAVA_06,
                TOPJAVA_07.getName(), TOPJAVA_07,
                TOPJAVA_08.getName(), TOPJAVA_08,
                MASTERJAVA_01.getName(), MASTERJAVA_01);
    }

    public static void setUp() {
        GroupDao dao = DBIProvider.getDao(GroupDao.class);
        dao.clean();
        DBIProvider.getDBI().useTransaction((conn, status) -> {
            GROUPS.values().forEach(dao::insert);
        });
        TOPJAVA_06_ID = TOPJAVA_06.getId();
        TOPJAVA_07_ID = TOPJAVA_07.getId();
        TOPJAVA_08_ID = TOPJAVA_08.getId();
        MASTERJAVA_01_ID = MASTERJAVA_01.getId();
    }
}
