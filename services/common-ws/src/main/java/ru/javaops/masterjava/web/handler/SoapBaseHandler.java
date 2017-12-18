package ru.javaops.masterjava.web.handler;

import com.sun.xml.ws.api.handler.MessageHandler;
import com.sun.xml.ws.api.handler.MessageHandlerContext;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import java.util.Set;

public abstract class SoapBaseHandler implements MessageHandler<MessageHandlerContext> {

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public void close(MessageContext context) {
    }

    protected static boolean isOutbound(MessageHandlerContext context) {
        return (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
    }
}
