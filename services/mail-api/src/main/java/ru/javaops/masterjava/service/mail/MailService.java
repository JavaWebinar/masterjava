package ru.javaops.masterjava.service.mail;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://mail.javaops.ru/")
//@SOAPBinding(
//        style = SOAPBinding.Style.DOCUMENT,
//        use= SOAPBinding.Use.LITERAL,
//        parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface MailService {

    @WebMethod
    void sendMail(
            @WebParam(name = "to") List<Addressee> to,
            @WebParam(name = "cc") List<Addressee> cc,
            @WebParam(name = "subject") String subject,
            @WebParam(name = "body") String body);
}