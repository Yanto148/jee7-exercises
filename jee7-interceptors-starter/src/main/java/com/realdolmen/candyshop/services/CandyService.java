package com.realdolmen.candyshop.services;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.interceptors.ActivateTimer;
import com.realdolmen.candyshop.repository.CandyRepository;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@Remote
@LocalBean
// TODO Apply the Interceptor
@ActivateTimer
public class CandyService implements CandyServiceRemote {
    @Inject
    CandyRepository candyRepository;

    @Inject
    PersonService personService;

    @Override
    public CandyRepository getCandyRepository() {
        return candyRepository;
    }

    PersonService getPersonService() {
        return personService;
    }

    @Override
    public List<Candy> findAllCandy() {
        return candyRepository.findAllCandy();
    }

    @Override
    public List<Candy> findCandyByColor(CandyColor candyColor) {
        return candyRepository.findCandyByColor(candyColor);
    }
}
