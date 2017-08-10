package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.repositories.CandyRepository;
import com.realdolmen.candyshop.web.CandyController;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;

public class CandyService {

    @Inject
    private CandyRepository candyRepository;
    @Inject
    private PersonService personService;

    public void findAllCandy() {
    }

    public CandyRepository getCandyRepository() {
        return candyRepository;
    }

    public PersonService getPersonService() {
        return personService;
    }
}
