package com.realdolmen.course.beans;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class PeopleListController
{
    @Inject
    private PersonServiceBean serviceBean;

    private List<Person> persons;

    @PostConstruct
    public void fetchPersons()
    {
        this.persons = serviceBean.findAll();
    }

    public List<Person> getPersons()
    {
        return persons;
    }

    public void remove(Long id)
    {
        serviceBean.remove(id);
    }
}
