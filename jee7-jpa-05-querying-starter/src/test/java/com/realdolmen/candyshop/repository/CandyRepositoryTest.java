package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.AbstractPersistenceTest;
import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CandyRepositoryTest extends AbstractPersistenceTest {
    private CandyRepository repository;

    @Before
    public void initializeRepository() {
        repository = new CandyRepository();
        repository.em = em;
    }

    @Test
    public void findAverageCandyPrice() throws Exception {
        double avg = repository.findAverageCandyPrice();
        assertEquals(5.15, avg, 0.01);
    }

    @Test
    public void findCandyByNameLike() throws Exception {
        List<Candy> candy = repository.findCandyByNameLike("Gummy");
        assertEquals(2, candy.size());
        assertEquals("Jumbo Gummy Bears", candy.get(0).getName());
        assertEquals("Roaring Gummy Bears", candy.get(1).getName());
    }

    @Test
    public void findUniqueCandyForPersonOrderHistory() throws Exception {
        Person p = em.find(Person.class, 3000L);
        List<Candy> c = repository.findUniqueCandyForPersonOrderHistory(p);
        assertEquals(3, c.size());
        assertEquals("Jolly Ranger M&Ms", c.get(0).getName());
        assertEquals("Jumbo Gummy Bears", c.get(1).getName());
        assertEquals("Pink Kisses", c.get(2).getName());
    }
}
