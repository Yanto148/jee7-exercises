package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Person;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Stateless
public class PersonRepository {
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
