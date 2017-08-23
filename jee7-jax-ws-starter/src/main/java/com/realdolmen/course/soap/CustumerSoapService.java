package com.realdolmen.course.soap;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.Customer;
import com.realdolmen.course.exceptions.CustomerNotFoundException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.soap.SOAPException;
import java.util.List;

@WebService(serviceName = "CustumerService", name="CustumerServicePortType", portName = "CustomerServicePort")
public interface CustumerSoapService
{
    @WebMethod(operationName = "Create")
    void create(@WebParam(name = "name") String name, @WebParam(name = "address") Address address);

    @WebMethod(operationName = "QuerySingle")
    Customer querySingle(@WebParam(name = "id") Integer id) throws SOAPException;

    @WebMethod(operationName = "QueryAll")
    List<Customer> queryAll();

    @WebMethod(operationName = "QueryByName")
    Customer queryByName(@WebParam(name = "name") String name) throws SOAPException;
}
