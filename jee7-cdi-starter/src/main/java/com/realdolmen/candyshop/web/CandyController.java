package com.realdolmen.candyshop.web;

import com.realdolmen.candyshop.services.CandyService;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@RequestScoped
public class CandyController {
    @Inject
    private CandyService candyService;

    @Inject
    Logger log;

    public void findAllCandy()
    {
        log.log(Level.INFO, "Finding all candy...");
        candyService.findAllCandy();
    }

    public void findCandyByColor()
    {
        log.log(Level.INFO, "Finging candy by color...");
    }

    public CandyService getCandyService() {
        return candyService;
    }
}
