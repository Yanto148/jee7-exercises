package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Order;
import com.realdolmen.course.domain.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class OrderRepository
{
    @PersistenceContext
    EntityManager em;

    public Order save(Order order)
    {
        em.persist(order);
        return order;
    }

    public List<Order> findAll()
    {
        return em.createQuery("select o from Order o", Order.class).getResultList();
    }

    public Order findById(Long id)
    {
        return em.find(Order.class, id);
    }

    public void remove(long id)
    {
        TypedQuery<Order> query = em.createQuery("select o from Order o where o.id = :id", Order.class);
        query.setParameter("id", id);
        Order order = query.getSingleResult();
        if (order != null)
            em.remove(order);
    }
}
