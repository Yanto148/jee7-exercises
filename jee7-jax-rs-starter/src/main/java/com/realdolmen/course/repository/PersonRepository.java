package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Order;
import com.realdolmen.course.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.awt.print.Book;
import java.lang.reflect.Type;
import java.util.List;

@Stateless
public class PersonRepository {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager em;

    public Person save(Person person) {
        em.persist(person);
        return person;
    }

    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    public List<Person> findAll() {
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }

    public List<Person> findByName(String firstName, String lastName)
    {
        TypedQuery<Person> query = em.createQuery("select p from Person p where p.firstName = :firstName AND p.lastName = :lastName", Person.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    public Long countPeopleByEmail(String email) {
        return em.createQuery("select count(p) from Person p where p.email = :email", Long.class).setParameter("email", email).getSingleResult();
    }

    public void remove(long personId) {
        logger.info("Removing person with id " + personId);
        em.remove(em.getReference(Person.class, personId));
    }
}
