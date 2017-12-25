package ru.javaops.masterjava.service.mail.util;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.io.input.CloseShieldInputStream;
import ru.javaops.masterjava.service.mail.Addressee;
import ru.javaops.masterjava.service.mail.Attachment;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import java.io.*;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MailUtils {

    public static Set<Addressee> split(String addressees) {
        Iterable<String> split = Splitter.on(',').trimResults().omitEmptyStrings().split(addressees);
        return ImmutableSet.copyOf(Iterables.transform(split, Addressee::new));
    }

    @Data
    @AllArgsConstructor
    public static class MailObject implements Serializable {
        private @NotNull String users;
        private String subject;
        private @NotNull String body;
        //  http://stackoverflow.com/questions/521171/a-java-collection-of-value-pairs-tuples
        private List<SimpleImmutableEntry<String, byte[]>> attachments;
    }

    public static List<Attachment> getAttachments(List<SimpleImmutableEntry<String, byte[]>> attachments) {
        return attachments.stream().map(a -> getAttachment(a.getKey(), a.getValue())).collect(Collectors.toList());
    }

    public static Attachment getAttachment(String name, byte[] attachData) {
        return new Attachment(name, new DataHandler((ProxyDataSource) () -> new ByteArrayInputStream(attachData)));
    }

    public static Attachment getAttachment(String name, InputStream inputStream) {
        //    http://stackoverflow.com/questions/2830561/how-to-convert-an-inputstream-to-a-datahandler
        //    http://stackoverflow.com/a/5924019/548473
        return new Attachment(name, new DataHandler((ProxyDataSource) () -> new CloseShieldInputStream(inputStream)));
    }

    public interface ProxyDataSource extends DataSource {
        @Override
        default OutputStream getOutputStream() throws IOException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        default String getContentType() {
            return "application/octet-stream";
        }

        @Override
        default String getName() {
            return "";
        }
    }
}
