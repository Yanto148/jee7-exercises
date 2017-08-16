package com.realdolmen.course.web;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.repository.PersonRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named("MySuperduperMegaSweetController")
public class MySpecialController
{
    @Inject
    private PersonRepository pr;

    public Person findPerson()
    {
        return pr.findById(1000L);
    }

    public int calculatePurposeOfLife()
    {
        return 5 * 8 + 2;
    }
}
