package com.realdolmen.candyshop.integration;

import com.realdolmen.candyshop.AbstractRemoteIntegrationTest;
import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.CandyColor;
import com.realdolmen.candyshop.services.CandyService;
import com.realdolmen.candyshop.services.CandyServiceInterface;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

public class CandyServiceIntegrationTest extends AbstractRemoteIntegrationTest
{
    private static final int TOTAL_CANDY_IN_TEST_DATASET = 6;

    CandyServiceInterface candyService;

    @Before
    public void getCandyRepoTest() throws Exception {
        candyService = (CandyServiceInterface) context.lookup("jee7-ejb-starter/CandyService!com.realdolmen.candyshop.services.CandyServiceInterface");
        assertNotNull(candyService);
    }

    @Test
    public void candyServiceShouldReturnAllCandyWhenAskedToDoSo() throws Exception {
        List<Candy> candy = candyService.findAllCandy();
        assertEquals(TOTAL_CANDY_IN_TEST_DATASET, candy.size());
    }

    @Test
    public void candyServiceShouldReturnsAllCandyByColor() throws Exception {
        CandyColor colorToQuery = CandyColor.RED;
        List<Candy> candy = candyService.findCandyByColor(colorToQuery);
        assertEquals(1, candy.size());
        assertEquals(colorToQuery, candy.get(0).getColor());
        }
        
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