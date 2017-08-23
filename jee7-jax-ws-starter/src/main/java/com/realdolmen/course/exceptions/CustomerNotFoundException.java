package com.realdolmen.course.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "customerNotFound", faultBean = "com.realdolmen.course.exceptions.FaultBean")
public class CustomerNotFoundException extends Exception
{
    private FaultBean faultInfo;

    public CustomerNotFoundException(String message, FaultBean bean) {
        super(message);
    }

    public FaultBean getFaultInfo() {
        return faultInfo;
    }
}
