package ru.javaops.web;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.javaops.masterjava.ExceptionType;

import javax.xml.bind.annotation.XmlType;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@XmlType(namespace = "http://common.javaops.ru/")
public class FaultInfo {
    private @NonNull ExceptionType type;

    @Override
    public String toString() {
        return type.toString();
    }
}
