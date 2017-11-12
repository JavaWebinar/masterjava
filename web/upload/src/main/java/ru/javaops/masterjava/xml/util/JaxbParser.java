package ru.javaops.masterjava.xml.util;

import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;


/**
 * Marshalling/Unmarshalling JAXB facade
 */
public class JaxbParser {

    private JAXBContext ctx;
    protected Schema schema;

    public JaxbParser(Class... classesToBeBound) {
        try {
            init(JAXBContext.newInstance(classesToBeBound));
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }

    //    http://stackoverflow.com/questions/30643802/what-is-jaxbcontext-newinstancestring-contextpath
    public JaxbParser(String context) {
        try {
            init(JAXBContext.newInstance(context));
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }

    private void init(JAXBContext ctx) {
        this.ctx = ctx;
    }

    //    https://stackoverflow.com/a/7400735/548473
    public JaxbMarshaller createMarshaller() {
        try {
            JaxbMarshaller marshaller = new JaxbMarshaller(ctx);
            if (schema != null) {
                marshaller.setSchema(schema);
            }
            return marshaller;
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }

    //    https://stackoverflow.com/a/7400735/548473
    public JaxbUnmarshaller createUnmarshaller() {
        try {
            JaxbUnmarshaller unmarshaller = new JaxbUnmarshaller(ctx);
            if (schema != null) {
                unmarshaller.setSchema(schema);
            }
            return unmarshaller;
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public void validate(String str) throws IOException, SAXException {
        validate(new StringReader(str));
    }

    public void validate(Reader reader) throws IOException, SAXException {
        schema.newValidator().validate(new StreamSource(reader));
    }
}
