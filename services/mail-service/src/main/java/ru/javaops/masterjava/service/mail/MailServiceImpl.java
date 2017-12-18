package ru.javaops.masterjava.service.mail;

import ru.javaops.masterjava.web.WebStateException;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;
import java.util.List;
import java.util.Set;

@WebService(endpointInterface = "ru.javaops.masterjava.service.mail.MailService", targetNamespace = "http://mail.javaops.ru/"
//          , wsdlLocation = "WEB-INF/wsdl/mailService.wsdl"
)
//@StreamingAttachment(parseEagerly=true, memoryThreshold=40000L)
@MTOM
@HandlerChain(file = "mailWsHandlers.xml")
public class MailServiceImpl implements MailService {

//    @Resource
//    private WebServiceContext wsContext;

    @Override
    public String sendToGroup(Set<Addressee> to, Set<Addressee> cc, String subject, String body, List<Attachment> attachments) throws WebStateException {
/*
        MessageContext mCtx = wsContext.getMessageContext();
        Map<String, List<String>> headers = (Map<String, List<String>>) mCtx.get(MessageContext.HTTP_REQUEST_HEADERS);

        HttpServletRequest request = (HttpServletRequest) mCtx.get(MessageContext.SERVLET_REQUEST);
        HttpServletResponse response = (HttpServletResponse) mCtx.get(MessageContext.SERVLET_RESPONSE);

        int code = AuthUtil.checkBasicAuth(headers, MailWSClient.AUTH_HEADER);
        if (code != 0) {
            mCtx.put(MessageContext.HTTP_RESPONSE_CODE, code);
            throw new SecurityException();
        }
*/
        return MailSender.sendToGroup(to, cc, subject, body, attachments);
    }

    @Override
    public GroupResult sendBulk(Set<Addressee> to, String subject, String body, List<Attachment> attachments) throws WebStateException {
        return MailServiceExecutor.sendBulk(to, subject, body, attachments);
    }
}