package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CandyRepository {
    EntityManager em;

    public double findAverageCandyPrice() {
        // TODO: implement this method
        TypedQuery<Double> query = em.createQuery("SELECT avg(c.price) FROM Candy c", Double.class);
        return query.getSingleResult();
    }

    public List<Candy> findCandyByNameLike(String name) {
        // TODO: implement this method
        TypedQuery<Candy> query = em.createQuery("SELECT c FROM Candy c WHERE c.name LIKE :name", Candy.class);
        query.setParameter("name", '%' + name + '%');
        return query.getResultList();
    }

    public List<Candy> findUniqueCandyForPersonOrderHistory(Person p) {
        // TODO: implement this method
        TypedQuery<Candy> query = em.createQuery(
                "select distinct ol.candy from Person p join p.orderHistory o join o.orderLines ol where p = :person order by ol.candy.name",
                Candy.class
        );
        query.setParameter("person", p);
        return query.getResultList();
    }
}