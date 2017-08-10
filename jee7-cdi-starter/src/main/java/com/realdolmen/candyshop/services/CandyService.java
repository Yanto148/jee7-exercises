package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.repositories.CandyRepository;
import com.realdolmen.candyshop.web.CandyController;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class CandyService {

    @Inject
    Logger log;
    @Inject
    private CandyRepository candyRepository;
    @Inject
    private PersonService personService;

    public void findAllCandy()
    {
        log.log(Level.INFO, "Finding all candy...");
    }

    public CandyRepository getCandyRepository() {
        return candyRepository;
    }

    public PersonService getPersonService() {
        return personService;
    }
}
