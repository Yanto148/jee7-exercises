package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.repositories.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonService
{
    @Inject
    private PersonRepository personRepository;

    public void findPersonById(int i) {
    }

    public PersonRepository getPersonRepository() {
        return personRepository;
    }
}
