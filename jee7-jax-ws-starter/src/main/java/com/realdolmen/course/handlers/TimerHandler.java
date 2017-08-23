package com.realdolmen.course.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

public class TimerHandler implements SOAPHandler<SOAPMessageContext>
{
    long teller = 0;
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Set<QName> getHeaders() {
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context)
    {
        System.out.println("In handleMessage");
        System.out.println(context.getMessage());
        Boolean isOutBound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!isOutBound)
            teller = System.nanoTime();
        else
        {
            long totalTime = teller - System.nanoTime();
            logger.info("Total time taken: " + totalTime);
            System.out.println("Total time taken: " + totalTime);
        }
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {

    }
}
