package ru.javaops.masterjava.xml.util;

import com.google.common.io.Resources;
import org.junit.Test;
import ru.javaops.masterjava.xml.schema.CityType;
import ru.javaops.masterjava.xml.schema.ObjectFactory;
import ru.javaops.masterjava.xml.schema.Payload;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class JaxbParserTest {
    //    https://google.github.io/styleguide/javaguide.html#s5.2.4-constant-names
    private static final JaxbParser jaxbParser;
    private static final JaxbMarshaller marshaller;
    private static final JaxbUnmarshaller unmarshaller;

    static {
        jaxbParser = new JaxbParser(ObjectFactory.class);
        jaxbParser.setSchema(Schemas.ofClasspath("payload.xsd"));
        marshaller = jaxbParser.createMarshaller();
        unmarshaller = jaxbParser.createUnmarshaller();
    }

    @Test
    public void testPayload() throws Exception {
//        JaxbParserTest.class.getResourceAsStream("/city.xml")
        Payload payload = unmarshaller.unmarshal(
                Resources.getResource("payload.xml").openStream());
        String strPayload = marshaller.marshal(payload);
        jaxbParser.validate(strPayload);
        System.out.println(strPayload);
    }

    @Test
    public void testCity() throws Exception {
        JAXBElement<CityType> cityElement = unmarshaller.unmarshal(
                Resources.getResource("city.xml").openStream());
        CityType city = cityElement.getValue();
        JAXBElement<CityType> cityElement2 =
                new JAXBElement<>(new QName("http://javaops.ru", "City"), CityType.class, city);
        String strCity = marshaller.marshal(cityElement2);
        jaxbParser.validate(strCity);
        System.out.println(strCity);
    }
}