package com.realdolmen.candyshop.web;

import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.services.PersonService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PersonController {

    @Inject PersonService personService;

    public void savePerson(Person person) {
    }

    public void findPersonById(int i) {
    }

    public PersonService getPersonService() {
        return personService;
    }
}
