package com.realdolmen.candyshop.integration;

import com.realdolmen.candyshop.AbstractRemoteIntegrationTest;
import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.services.CandyServiceRemote;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

public class CandyServiceIntegrationTest extends AbstractRemoteIntegrationTest
{
    private static CandyServiceRemote candyService;

    @BeforeClass
    public static void getCandyRepoTest() throws Exception {
        candyService = lookup("jee7-ejb-starter/CandyService!com.realdolmen.candyshop.services.CandyServiceRemote");
    }

    @Test
    public void candyServiceHasRepo()
    {
        assertNotNull(candyService);
        //assertNotNull(candyService.getCandyRepository());
    }

    @Test
    public void shouldFindAllCandy() {
        List<Candy> candies = candyService.findAllCandy();
        assertEquals(6, candies.size());
    }

    @Test
    public void shouldFindCandyByColor() {
        List<Candy> candies = candyService.findCandyByColor(CandyColor.BLUE);
        assertEquals(1, candies.size());
    }
}