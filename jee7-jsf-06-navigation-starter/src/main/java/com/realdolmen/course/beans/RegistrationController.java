package com.realdolmen.course.beans;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;
import com.realdolmen.course.utils.DateUtils;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by cda5732 on 2/03/2017.
 */
@Named
@SessionScoped
public class RegistrationController implements Serializable {
    @EJB
    PersonServiceBean personService;

    private Person person = new Person();

    public Person getPerson() {
        return person;
    }

    public String savePerson() {
        personService.save(person);
        this.person = new Person();
        // TODO From `confirm` go to `people` instead of going back to `registration`
        return "people";
    }
}
