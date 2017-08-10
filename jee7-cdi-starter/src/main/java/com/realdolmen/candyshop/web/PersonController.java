package com.realdolmen.candyshop.web;

import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.services.PersonService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
public class PersonController {

    @Inject PersonService personService;
    @Inject
    Logger log;

    public void savePerson(Person person)
    {
        log.log(Level.INFO, "Saving person to database...");
    }

    public void findPersonById(int i)
    {
        log.log(Level.INFO, "Finding person by id...");
        personService.findPersonById(1);
    }

    public PersonService getPersonService() {
        return personService;
    }
}
