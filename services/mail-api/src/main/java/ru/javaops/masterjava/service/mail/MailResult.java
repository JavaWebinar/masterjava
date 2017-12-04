package ru.javaops.masterjava.service.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
public class MailResult {
    public static final String OK = "OK";

    @XmlAttribute
    private @NonNull String email;
    @XmlValue
    private String result;

    public boolean isOk() {
        return OK.equals(result);
    }

    @Override
    public String toString() {
        return "'" + email + "' result: " + result;
    }
}