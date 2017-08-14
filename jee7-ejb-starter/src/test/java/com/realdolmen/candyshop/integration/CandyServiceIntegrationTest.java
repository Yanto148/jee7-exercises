package com.realdolmen.candyshop.integration;

import com.realdolmen.candyshop.AbstractRemoteIntegrationTest;
import com.realdolmen.candyshop.services.CandyService;
import com.realdolmen.candyshop.services.CandyServiceInterface;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CandyServiceIntegrationTest extends AbstractRemoteIntegrationTest
{
    CandyServiceInterface candyService;

    @Before
    public void getCandyRepoTest() throws Exception {
        candyService = (CandyServiceInterface) context.lookup("jee7-ejb-starter/CandyService!com.realdolmen.candyshop.services.CandyServiceInterface");

    }

    @Test
    public void candyServiceHasRepo()
    {
        assertNotNull(candyService);
        assertNotNull(candyService.getCandyRepository());
    }
}