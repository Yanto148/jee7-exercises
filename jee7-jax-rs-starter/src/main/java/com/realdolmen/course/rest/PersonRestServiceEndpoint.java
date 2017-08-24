package com.realdolmen.course.rest;

import com.realdolmen.course.domain.Person;
import com.realdolmen.course.service.PersonServiceBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Path("/people")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class PersonRestServiceEndpoint
{
    @EJB
    PersonServiceBean personService;

    @Context
    UriInfo uriInfo;

    // Met personlist wrapper kunnen we de xml aanpassen, zo kunnen we het root element 'people' noemen, standaard noemt dit collection
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public PersonList findAll() {
        return new PersonList(personService.findAll());
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/all")
    public List<Person> findAllNoWrapper() {
        return personService.findAll();
    }

    @GET
    @Path("/person")
    public List<Person> findByName(@QueryParam("firstname") String firstName, @QueryParam("lastname") String lastName)
    {
        return personService.findByName(firstName, lastName);
    }

    @GET
    @Path("/person/{id}")
    public Person findById(@PathParam("id") long id)
    {
        return personService.findById(id);
    }

//    @POST
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Person save(Person person)
//    {
//        return personService.save(person);
//    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response save(Person person)
    {
        personService.save(person);

        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder();
        uriBuilder.path("/people");
        uriBuilder.path("/person");
        uriBuilder.path("{id}");
        URI uri = uriBuilder.build(person.getId());

        Response.ResponseBuilder builder = Response.ok();
        builder.location(uri);
        builder.entity(person);
        //return builder.build();
        return Response.created(uri).build();
    }
}
