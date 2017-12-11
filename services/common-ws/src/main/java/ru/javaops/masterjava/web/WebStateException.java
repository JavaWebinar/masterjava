package ru.javaops.masterjava.web;


import lombok.Getter;
import ru.javaops.masterjava.ExceptionType;

import javax.xml.ws.WebFault;

@WebFault(name = "webStateException", targetNamespace = "http://common.javaops.ru/")
@Getter
public class WebStateException extends Exception {
    private FaultInfo faultInfo;

    public WebStateException(String cause, FaultInfo faultInfo) {
        super(cause);
        this.faultInfo = faultInfo;
    }

    public WebStateException(String cause, ExceptionType type) {
        this(cause, new FaultInfo(type));
    }

    public WebStateException(Throwable cause, ExceptionType type) {
        super(cause);
        this.faultInfo = new FaultInfo(type);
    }

    @Override
    public String toString() {
        return faultInfo.toString() + '\n' + super.toString();
    }
}
