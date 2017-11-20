package ru.javaops.masterjava.persist;

import com.google.common.collect.ImmutableMap;
import ru.javaops.masterjava.persist.dao.CityDao;
import ru.javaops.masterjava.persist.model.City;

import java.util.Map;

public class CityTestData {
    public static City KIEV;
    public static City MINSK;
    public static City MOSCOW;
    public static City SPB;

    public static Map<String, City> CITIES;

    public static void init() {
        KIEV = new City("kiv", "Киев");
        MINSK = new City("mnsk", "Минск");
        MOSCOW = new City("mow", "Москва");
        SPB = new City("spb", "Санкт-Петербург");
        CITIES = ImmutableMap.of(
                KIEV.getRef(), KIEV,
                MINSK.getRef(), MINSK,
                MOSCOW.getRef(), MOSCOW,
                SPB.getRef(), SPB);
    }

    public static void setUp() {
        CityDao dao = DBIProvider.getDao(CityDao.class);
        dao.clean();
        DBIProvider.getDBI().useTransaction((conn, status) -> {
            CITIES.values().forEach(dao::insert);
        });
    }
}
