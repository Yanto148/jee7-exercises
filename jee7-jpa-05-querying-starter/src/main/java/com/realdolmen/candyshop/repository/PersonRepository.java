package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonRepository {
    EntityManager em;


    public Person findPersonById(long id) {
        // TODO: implement this method
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.id = :id", Person.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Person> findAllPeople() {
        // TODO: implement this method
        //TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p ORDER BY p.lastName, p.firstName", Person.class);
        TypedQuery<Person> query = em.createNamedQuery("find all people", Person.class);
        return query.getResultList();
    }

    public void savePerson(Person p) {
        // TODO: implement this method
        em.persist(p);
    }

    public void deletePersonById(long id) {
        // TODO: implement this method
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.id = :id", Person.class);
        query.setParameter("id", id);
        Person person = query.getSingleResult();
        if (person != null) em.remove(person);
    }

    public void updatePerson(Person p) {
        // TODO: implement this method
        p = em.merge(p);

    }

    public long countAllPeople() {
        // TODO: implement this method
        List<Person> persons = this.findAllPeople();
        return persons.size();
    }
}
