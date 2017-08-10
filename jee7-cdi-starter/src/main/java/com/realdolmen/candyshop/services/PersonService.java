package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.repositories.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class PersonService
{
    @Inject
    private PersonRepository personRepository;

    @Inject
    Logger log;

    public void findPersonById(int i)
    {
        log.log(Level.INFO, "Finding person by id...");
        personRepository.findPersonById(i);
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }
}
