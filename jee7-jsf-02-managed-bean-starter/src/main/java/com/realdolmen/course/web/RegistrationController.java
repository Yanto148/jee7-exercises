package com.realdolmen.course.web;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;
import com.realdolmen.course.service.PersonServiceRemote;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@RequestScoped
@Named("registrationController")
public class RegistrationController
{
    @Inject
    private PersonServiceBean personService;

    private Person person;

    @PostConstruct
    private void initPerson()
    {
        this.person = personService.findById(1L);
    }

    public Person findPerson()
    {
        return person;
    }
}
