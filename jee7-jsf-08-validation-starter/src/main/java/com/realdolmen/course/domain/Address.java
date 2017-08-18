package com.realdolmen.course.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

// TODO Make all fields required

@Embeddable
public class Address implements Serializable {
    @NotNull @Size(min = 1, message = "Moet ingevuld zijn")
    private String street;
    @NotNull @Size(min = 1, message = "Moet ingevuld zijn")
    private String number;
    @NotNull @Size(min = 1, message = "Moet ingevuld zijn")
    private String city;
    @NotNull @Size(min = 1, message = "Moet ingevuld zijn")
    private String postalCode;

    public Address() {
    }

    public Address(String street, String number, String city, String postalCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return street + " " + number + " " + postalCode + " " + city;
    }
}
