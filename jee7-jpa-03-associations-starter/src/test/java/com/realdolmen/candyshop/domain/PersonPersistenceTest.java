package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.AbstractPersistenceTest;
import com.realdolmen.candyshop.util.DateUtils;
import org.junit.Test;

import javax.persistence.PersistenceException;
import java.util.List;

import static org.junit.Assert.*;

public class PersonPersistenceTest extends AbstractPersistenceTest {
    @Test
    public void personCanBePersisted() throws Exception {
        Person person = new Person();
        person.setFirstName("Jane");
        person.setLastName("Doe");
        em.persist(person);
        assertNotNull(person.getId());
    }

    @Test
    public void personCanBeLoaded() throws Exception {
        Person person = em.find(Person.class, 1000L);
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
    }

    @Test
    public void personHasBirthDate() throws Exception {
        Person jane = em.find(Person.class, 2000L);
        assertEquals(jane.getBirthDate(), DateUtils.createDate("1970-01-02"));
    }

    @Test
    public void personAgeIsCalculated() throws Exception {
        Person jane = em.find(Person.class, 2000L);
        assertTrue(jane.getAge() >= 47);
    }

    @Test(expected = PersistenceException.class)
    public void personRequiredFieldsAreChecked() throws Exception {
        Person p = new Person();
        em.persist(p);
        em.flush();
    }

    @Test
    public void personHasAnAddress() throws Exception {
        Person p = em.find(Person.class, 5000L);
        assertEquals("Turingstreet 1 2547 Newcastle", p.getAddress().toString());
    }

    @Test
    public void personHasCandyPreferences() throws Exception {
        Person p = em.find(Person.class, 3000L);
        List<CandyColor> prefs = p.getCandyPreferences();
        assertEquals(2, prefs.size());
        prefs.contains(CandyColor.BLUE);
        prefs.contains(CandyColor.YELLOW);
    }

    @Test
    public void personHasOrderHistory() throws Exception {
        Person p = em.find(Person.class, 3000L);
        List<Order> h = p.getOrderHistory();
        assertEquals(2, h.size());
    }

}
