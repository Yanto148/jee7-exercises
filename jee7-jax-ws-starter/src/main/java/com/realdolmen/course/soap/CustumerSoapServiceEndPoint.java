package com.realdolmen.course.soap;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.Customer;
import com.realdolmen.course.exceptions.CustomerNotFoundException;
import com.realdolmen.course.service.CustumerServiceBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.List;

@WebService(serviceName = "CustumerService", name="CustumerServicePortType", portName = "CustomerServicePort")
@Stateless
public class CustumerSoapServiceEndPoint implements CustumerSoapService
{
    @Inject
    private CustumerServiceBean custumerService;

    @Override
    @WebMethod(operationName = "Create")
    public void create(@WebParam(name = "name") String name, @WebParam(name = "address") Address address)
    {
        custumerService.createCustomer(name, address);
    }

    @Override
    @WebMethod(operationName = "QuerySingle")
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
    public List<Customer> queryAll()
    {
        return custumerService.findAll();
    }

    @Override
    @WebMethod(operationName = "QueryByName")
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