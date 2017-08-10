package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.AbstractPersistenceTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// TODO: use the AbstractPersistence Test
public class PersonPersistenceTest extends AbstractPersistenceTest {
    // TODO: add unit test personCanBePersisted()
    @Test
    public void personCanBePersisted()
    {
        Person person = new Person();
        person.setFirstName("Yanto");
        person.setLastName("Maes");
        em.persist(person);

        assertNotNull(person.getId());
    }

    // TODO: add unit test personCanBeLoaded()
    @Test
    public void personCanBeLoaded()
    {
        Person person = em.find(Person.class, 1000L);
        assertNotNull(person);
        assertEquals(person.getFirstName(), "John");
    }
}
