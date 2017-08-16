package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.interceptors.ActivateTimer;
import com.realdolmen.candyshop.repository.PersonRepository;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@Remote
@LocalBean
// TODO Apply the Interceptor
@ActivateTimer
public class PersonService implements PersonServiceRemote {
    @Inject
    PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        personRepository.savePerson(person);
        return person;
    }

    PersonRepository getPersonRepository() {
        return personRepository;
    }

    @Override
    public Person findPersonById(long id) {
        return personRepository.findPersonById(id);
    }

    @Override
    public List<Person> findAllPeople() {
        return personRepository.findAllPeople();
    }
}
