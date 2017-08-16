package com.realdolmen.candyshop.utils;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by cda5732 on 1/03/2017.
 */
public class BankProducers {
    // TODO Get the EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    // TODO Produce the EntityManager
    public EntityManager entityManager() {
        return entityManager;
    }
}
