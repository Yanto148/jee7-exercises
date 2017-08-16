package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Address;
import com.realdolmen.candyshop.domain.Person;
import com.realdolmen.candyshop.util.DateUtils;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;

@Stateful
@Remote
@LocalBean
public class RegistrationService implements RegistrationServiceRemote {
    private Person person;
    private Address address;

    @Inject
    PersonService personService;

    @Override
    public void addPerson(String firstName, String lastName, String birthDate)
    {
        this.person = new Person();
        this.person.setFirstName(firstName);
        this.person.setLastName(lastName);
        this.person.setBirthDate(DateUtils.createDate(birthDate));
    }

    @Override
    public void addAddress(String street, String number, String city, String postCode)
    {
        this.address = new Address();
        this.address.setStreet(street);
        this.address.setNumber(number);
        this.address.setCity(city);
        this.address.setPostalCode(postCode);
    }

    @Override
    @Remove
    public Person savePerson()
    {
        this.person.setAddress(this.address);
        return personService.savePerson(person);
    }
}
