package ru.javaops.masterjava.service.mail.util;

import lombok.AllArgsConstructor;
import ru.javaops.masterjava.service.mail.Attachment;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Attachments {
    public static Attachment getAttachment(String name, InputStream inputStream) {
        return new Attachment(name, new DataHandler(new InputStreamDataSource(inputStream)));
    }

    //    http://stackoverflow.com/a/10783565/548473
    @AllArgsConstructor
    private static class InputStreamDataSource implements DataSource {
        private InputStream inputStream;

        @Override
        public InputStream getInputStream() throws IOException {
            if (inputStream == null) {
                throw new IOException("Second getInputStream() call is not supported");
            }
            InputStream res = inputStream;
            inputStream = null;
            return res;
        }

        @Override
        public OutputStream getOutputStream() throws IOException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override
        public String getContentType() {
            return "application/octet-stream";
        }

        @Override
        public String getName() {
            return "";
        }
    }
}
