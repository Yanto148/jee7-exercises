package com.realdolmen.course.rest;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("/people")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class PersonRestServiceEndpoint
{
    @EJB
    PersonServiceBean personService;

    // Met personlist wrapper kunnen we de xml aanpassen, zo kunnen we het root element 'people' noemen, standaard noemt dit collection
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PersonList findAll() {
        return new PersonList(personService.findAll());
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/all")
    public List<Person> findAll2() {
        return personService.findAll();
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Person save(Person person)
    {
        return personService.save(person);
    }
}
