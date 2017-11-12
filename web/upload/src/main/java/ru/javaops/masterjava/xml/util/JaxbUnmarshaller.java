package ru.javaops.masterjava.xml.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;
import javax.xml.validation.Schema;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

public class JaxbUnmarshaller {
    private Unmarshaller unmarshaller;

    public JaxbUnmarshaller(JAXBContext ctx) throws JAXBException {
        unmarshaller = ctx.createUnmarshaller();
    }

    public void setSchema(Schema schema) {
        unmarshaller.setSchema(schema);
    }

    public <T> T unmarshal(InputStream is) throws JAXBException {
        return (T) unmarshaller.unmarshal(is);
    }

    public <T> T unmarshal(Reader reader) throws JAXBException {
        return (T) unmarshaller.unmarshal(reader);
    }

    public <T> T unmarshal(String str) throws JAXBException {
        return (T) unmarshal(new StringReader(str));
    }

    public <T> T unmarshal(XMLStreamReader reader, Class<T> elementClass) throws JAXBException {
        return unmarshaller.unmarshal(reader, elementClass).getValue();
    }
}