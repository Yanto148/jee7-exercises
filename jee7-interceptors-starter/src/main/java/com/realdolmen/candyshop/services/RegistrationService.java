package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Address;
import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.interceptors.ActivateTimer;
import com.realdolmen.candyshop.util.DateUtils;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;

/**
 * Created by cda5732 on 1/03/2017.
 */
@Stateful
@Remote
@LocalBean
// TODO Apply the Interceptor
@ActivateTimer
public class RegistrationService implements RegistrationServiceRemote {
    @Inject
    PersonService service;

    private Person person;
    private Address address;

    @Override
    public void addPerson(String firstName, String lastName, String birthDate) {
        this.person = new Person();
        this.person.setFirstName(firstName);
        this.person.setLastName(lastName);
        this.person.setBirthDate(DateUtils.createDate(birthDate));
    }

    @Override
    public void addAddress(String street, String number, String city, String postalCode) {
        this.address = new Address(street, number, city, postalCode);
    }

    @Override
    @Remove
    public Person registerPerson() {
        this.person.setAddress(this.address);
        return service.savePerson(person);
    }
}
