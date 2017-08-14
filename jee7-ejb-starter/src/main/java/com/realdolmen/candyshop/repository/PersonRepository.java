package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Person;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// TODO Make this a Stateless Session Bean
@Stateless
public class PersonRepository {
    // TODO Retrieve the EntityManager
    @Inject
    EntityManager em;

    public Person findPersonById(long id) {
        return em.find(Person.class, id);
    }

    public List<Person> findAllPeople() {
        return em.createNamedQuery("find all people", Person.class).getResultList();
    }

    public void savePerson(Person p) {
        em.persist(p);
    }

    public void deletePersonById(long id) {
        em.remove(em.getReference(Person.class, id));
    }

    public void updatePerson(Person p) {
        em.merge(p);
    }

    public long countAllPeople() {
        return em.createQuery("select count(p) from Person p", Long.class).getSingleResult();
    }

}
