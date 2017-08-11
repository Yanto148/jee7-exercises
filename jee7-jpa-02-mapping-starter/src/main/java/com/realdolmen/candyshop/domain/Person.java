package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.util.DateUtils;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    // TODO: make non nullable and restrict to 200 characters
    @Column(length = 200, nullable = false)
    private String firstName;

    // TODO: make non nullable and restrict to 200 characters
    @Column(length = 200, nullable = false)
    private String lastName;

    // TODO: add property birthdate (store only date portion) make it non nullable
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthDate;

    // TODO: add property age (not stored in database, but calculated from birthdate
    @Transient
    private long age;       // Can be long and does not have to be Long since birthday is not nullable. If birthday was nullable, this would have to be Long

    // TODO: add embedded mapping to address
    @Embedded
    private Address address;

    // TODO: add element collection (table name "candy_preferences", columns ("candy_color" and "person_id")
    @ElementCollection
    @CollectionTable(name = "candy_preferences")
    @Column(name = "candy_color")
    @Enumerated(EnumType.STRING)
    private List<CandyColor> candyPreferences = new ArrayList<>();

    @PostLoad
    public void initializeAge() {
        this.age = DateUtils.yearsFrom(birthDate);
    }

    public Long getId() {
        return id;
    }

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

    public Date getBirthDate() {
        return birthDate;
    }

    public long getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<CandyColor> getCandyPreferences() {
        return candyPreferences;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCandyPreferences(List<CandyColor> candyPreferences) {
        this.candyPreferences = candyPreferences;
    }
}
