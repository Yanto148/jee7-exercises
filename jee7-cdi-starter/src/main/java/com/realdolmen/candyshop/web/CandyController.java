package com.realdolmen.candyshop.web;

import com.realdolmen.candyshop.services.CandyService;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class CandyController {
    @Inject
    private CandyService candyService;

    public void findAllCandy() {
    }

    public void findCandyByColor() {
    }

    public CandyService getCandyService() {
        return candyService;
    }
}
