package com.realdolmen.course.beans;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;
import com.realdolmen.course.utils.DateUtils;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by cda5732 on 2/03/2017.
 */

// TODO Make this component session scoped

@Named
@SessionScoped
public class RegistrationController implements Serializable {
    // TODO Initialize the person with a default constructor
    //private Person person = new Person("Theo", "Tester", DateUtils.createDate("1970-01-01"));
    private Person person;

    @PostConstruct
    private void init()
    {
        person = new Person();
        person.setAddress(new Address());
    }

    // TODO Inject the PersonServiceBean
    @Inject
    private PersonServiceBean serviceBean;

    public Person getPerson() {
        return person;
    }

    // TODO Add a method that saves the person into the database, clears the person field and navigates back to registration
    public String register()
    {
        serviceBean.save(person);
        person = new Person();
        return "registration.xhtml";
    }

    public String confirm()
    {
        return "confirm.xhtml";
    }
}
