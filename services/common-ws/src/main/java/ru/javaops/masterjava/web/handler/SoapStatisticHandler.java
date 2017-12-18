package ru.javaops.masterjava.web.handler;

import com.sun.xml.ws.api.handler.MessageHandlerContext;
import ru.javaops.masterjava.web.Statistics;

public class SoapStatisticHandler extends SoapBaseHandler {

    private static final String PAYLOAD = "PAYLOAD";
    private static final String START_TIME = "START_TIME";

    @Override
    public boolean handleMessage(MessageHandlerContext context) {
        if (isOutbound(context)) {
            count(context, Statistics.RESULT.SUCCESS);
        } else {
            String payload = context.getMessage().getPayloadLocalPart();
            context.put(PAYLOAD, payload);
            context.put(START_TIME, System.currentTimeMillis());
        }
        return true;
    }

    @Override
    public boolean handleFault(MessageHandlerContext context) {
        count(context, Statistics.RESULT.FAIL);
        return true;
    }

    private void count(MessageHandlerContext context, Statistics.RESULT result) {
        Statistics.count((String) context.get(PAYLOAD), (Long) context.get(START_TIME), result);
    }
}