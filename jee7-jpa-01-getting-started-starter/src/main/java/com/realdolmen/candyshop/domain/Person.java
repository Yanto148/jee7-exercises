package com.realdolmen.candyshop.domain;

import javax.persistence.*;
import java.util.Date;

// TODO: Make person a JPA entity
@Entity
public class Person {
    // TODO: add property 'id' (Long) which will be the auto-generated primary key
    @Id
    @GeneratedValue
    private Long id;

    // TODO: add properties 'firstName' and 'lastName' (String)
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }
}
