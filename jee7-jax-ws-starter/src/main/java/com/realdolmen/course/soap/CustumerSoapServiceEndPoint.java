package com.realdolmen.course.soap;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.Customer;
import com.realdolmen.course.service.CustumerServiceBean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.List;

//@WebService(endpointInterface = "com.realdolmen.course.soap.CustumerSoapService", serviceName = "CustumerService2", name="CustumerServicePortType", portName = "CustomerServicePort")
//@WebService(/*endpointInterface = "com.realdolmen.course.soap.CustumerSoapService", */wsdlLocation = "META-INF/contract.wsdl")
@WebService(endpointInterface = "com.realdolmen.course.soap.CustumerSoapService", wsdlLocation = "META-INF/contract.wsdl")
//@WebService
@Stateless
@HandlerChain(file = "handlers.xml")
public class CustumerSoapServiceEndPoint implements CustumerSoapService
{
    @Inject
    private CustumerServiceBean custumerService;

    @Override
    @WebMethod(operationName = "Create")
    //@WebMethod
    public void create(@WebParam(name = "name") String name, @WebParam(name = "address") Address address)
    {
        custumerService.createCustomer(name, address);
    }

    @Override
    @WebMethod(operationName = "QuerySingle")
    //@WebMethod
    public Customer querySingle(@WebParam(name = "id") Integer id) throws SOAPException {
        Customer customer = custumerService.findById(id);
        if (customer == null)
        {
            try {
                throw new SOAPFaultException(
                        SOAPFactory.newInstance()
                                .createFault("Custumer could not be found", new QName("notFound")));
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }
        return custumerService.findById(id);
    }

    @Override
    @WebMethod(operationName = "QueryAll")
    //@WebMethod
    public List<Customer> queryAll()
    {
        return custumerService.findAll();
    }

    @Override
    @WebMethod(operationName = "QueryByName")
    //@WebMethod
    public Customer queryByName(@WebParam(name = "name") String name) throws SOAPException
    {
        Customer customer = custumerService.findByName(name);
        if (customer == null)
        {
            try {
                throw new SOAPFaultException(
                        SOAPFactory.newInstance()
                                .createFault("Custumer could not be found", new QName("notFound")));
            } catch (SOAPException e) {
                e.printStackTrace();
            }
        }
        return custumerService.findByName(name);
    }
}