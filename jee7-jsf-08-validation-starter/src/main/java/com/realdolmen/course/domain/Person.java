package com.realdolmen.course.domain;

import com.realdolmen.course.utils.DateUtils;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * TODO Add the following validation constraints to Person
 * - `firstName`, `lastName` and `birthDate` are required
 * - `firstName` and `lastName` have max length of 200
 * - `birthDate` must be in the past
 */

@Entity
@NamedQuery(name = "find all people", query = "select p from Person p order by p.lastName, p.firstName")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    @NotNull @Size(min = 1, max = 200, message = "Moet tussen de 1 en de 200 karakters zijn")
    private String firstName;

    @Column(nullable = false, length = 200)
    @NotNull @Size(min = 1, max = 200, message = "Moet tussen de 1 en de 200 karakters zijn")
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @NotNull(message = "Moet ingevuld zijn") @Past(message = "Datum moet in het verleden liggen")
    private Date birthDate;

    @Transient
    private long age;

    @Version
    private int version;

    @Embedded
    private Address address;

    public Person() {
    }

    public Person(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

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

    public int getVersion() {
        return version;
    }

    public String name() {
        return firstName + " " + lastName;
    }
}
