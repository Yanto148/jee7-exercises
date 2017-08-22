package com.realdolmen.course.soap;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
@Stateless
public class PersonSoapServiceEndpoint implements PersonSoapService {

    @Inject
    private PersonServiceBean personService;

    @Override
    @WebMethod
    public List<Person> findAllPersons() {
        return personService.findAll();
    }
}
