package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.util.DateUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
// TODO: subclass from Tracked
public class Person extends Tracked {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 200)
    private String firstName;

    @Column(nullable = false, length = 200)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthDate;

    @Transient
    private long age;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "candy_preferences")
    @Enumerated(EnumType.STRING)
    @Column(name = "candy_color")
    private List<CandyColor> candyPreferences = new ArrayList<>();

    @OneToMany(mappedBy = "person")
    private List<Order> orderHistory = new ArrayList<>();

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

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        initializeAge();
    }

    public long getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<CandyColor> getCandyPreferences() {
        return candyPreferences;
    }

    public void setCandyPreferences(List<CandyColor> candyPreferences) {
        this.candyPreferences = candyPreferences;
    }

    public List<Order> getOrderHistory() {
        return Collections.unmodifiableList(this.orderHistory);
    }

    void addOrderToHistory(Order order) {
        orderHistory.add(order);
    }
}
