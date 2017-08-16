package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Person;

import javax.ejb.Remote;
import java.util.List;

public interface PersonServiceRemote {
    Person savePerson(Person person);

    Person findPersonById(long id);

    List<Person> findAllPeople();
}
