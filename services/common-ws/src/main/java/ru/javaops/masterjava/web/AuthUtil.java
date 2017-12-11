package ru.javaops.masterjava.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.util.List;
import java.util.Map;

import static com.google.common.net.HttpHeaders.AUTHORIZATION;

@Slf4j
public class AuthUtil {

    public static String encodeBasicAuthHeader(String name, String passw) {
        String authString = name + ":" + passw;
        return "Basic " + DatatypeConverter.printBase64Binary(authString.getBytes());
    }

    public static int checkBasicAuth(Map<String, List<String>> headers, String basicAuthCredentials) {
        List<String> autHeaders = headers.get(AUTHORIZATION);
        if ((autHeaders == null || autHeaders.isEmpty())) {
            log.warn("Unauthorized access");
            return HttpServletResponse.SC_UNAUTHORIZED;
        } else {
            if (!autHeaders.get(0).equals(basicAuthCredentials)) {
                log.warn("Wrong password access");
                return HttpServletResponse.SC_FORBIDDEN;
            }
            return 0;
        }
    }
}
