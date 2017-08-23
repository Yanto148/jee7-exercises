package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.Customer;
import com.realdolmen.course.domain.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CustomerRepository
{
    @PersistenceContext
    EntityManager em;

    public void createCustomer(String name, Address address)
    {
        Customer customer = new Customer(name, address);
        em.persist(customer);
    }

    public Customer findById(Integer id)
    {
        return em.find(Customer.class, id);
    }

    public List<Customer> findAll()
    {
        return em.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    public Customer findByName(String name)
    {
        return em.createQuery("select c from Customer c where c.name = :name", Customer.class)
                .setParameter("name", name)
                .getSingleResult();

    }
}
