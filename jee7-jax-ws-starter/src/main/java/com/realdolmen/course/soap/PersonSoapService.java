package com.realdolmen.course.soap;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface PersonSoapService
{

    @WebMethod
    @WebResult(name="persons") List<Person> findAllPersons();
}
