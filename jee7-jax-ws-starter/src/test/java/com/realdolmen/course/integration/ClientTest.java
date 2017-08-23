package com.realdolmen.course.integration;

import com.realdolmen.course.domain.Customer;
import com.realdolmen.course.soap.CustumerSoapService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;;

public class ClientTest
{
    private CustumerSoapService custumerSoapService;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setupBeforeClass() throws MalformedURLException {
        URL wsdlLocation = new URL("http://localhost:8080/jee7-jax-ws-starter/CustumerSoapServiceEndPoint?wsdl");
        QName serviceName = new QName("http://soap.course.realdolmen.com/", "CustumerSoapServiceEndPointService");
        Service webService = Service.create(wsdlLocation, serviceName);;
        custumerSoapService = webService.getPort(CustumerSoapService.class);
    }

    @Test
    public void shouldReturnAllCustomers()
    {
        List<Customer> result = custumerSoapService.queryAll();
        assertNotNull(result);
        assertFalse(result.isEmpty());
        result.stream().map(Customer::toString).forEach(logger::info);
    }
}
