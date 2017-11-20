package ru.javaops.masterjava.upload;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import ru.javaops.masterjava.persist.DBIProvider;
import ru.javaops.masterjava.persist.dao.CityDao;
import ru.javaops.masterjava.persist.model.City;
import ru.javaops.masterjava.xml.util.StaxStreamProcessor;

import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
public class CityProcessor {
    private final CityDao cityDao = DBIProvider.getDao(CityDao.class);

    public Map<String, City> process(StaxStreamProcessor processor) throws XMLStreamException {
        val map = cityDao.getAsMap();
        val newCities = new ArrayList<City>();

        while (processor.startElement("City", "Cities")) {
            val ref = processor.getAttribute("id");
            if (!map.containsKey(ref)) {
                newCities.add(new City(ref, processor.getText()));
            }
        }
        log.info("Insert batch " + newCities);
        cityDao.insertBatch(newCities);
        return cityDao.getAsMap();
    }
}
