package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Person;

import javax.ejb.Remove;
import java.util.Date;

public interface RegistrationServiceRemote {
    void addPerson(String firstName, String lastName, String birthDate);

    void addAddress(String street, String number, String city, String postCode);

    @Remove     // Doet hier niets, meer een documenterende reden hier!
    Person savePerson();
}
