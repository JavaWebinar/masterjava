package ru.javaops.masterjava;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.xml.bind.annotation.XmlType;

@Getter
@AllArgsConstructor
@XmlType(namespace = "http://common.javaops.ru/")
public enum ExceptionType {
    SYSTEM("Системная ошибка"),
    DATA_BASE("Ошибка базы данных"),
    STATE("Неверное состояние приложения"),
    AUTHORIZATION("Ошибка авторизации"),
    CONFIGURATION("Ошибка конфигурирования"),
    ILLEGAL_ARGUMENT("Неверный аргумент"),
    BPM("Ошибка бизнес-процесса"),
    FILE("Ошибка при работе с файловой системой"),
    REPORTS("Ошибка в отчете"),
    EMAIL("Ошибка при отправке почты"),
    TEMPLATE("Ошибка в шаблонах"),
    ONE_C("Ошибка в системе 1C"),
    ATTACHMENT("Ошибка вложенного файла"),
    LDAP("Ошибка соединения с LDAP"),
    SOAP("Ошибка веб-сервиса"),
    NETWORK("Сетевая Ошибка");

    final private String descr;

    @Override
    public String toString() {
        return name() + " (" + descr + ')';
    }
}
