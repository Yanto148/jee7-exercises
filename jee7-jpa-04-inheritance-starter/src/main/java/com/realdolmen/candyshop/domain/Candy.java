package com.realdolmen.candyshop.domain;

import javax.persistence.*;

// TODO: make abstract
// TODO: use inheritance strategy and set discriminator column name
// TODO: subclass from Tracked
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "candy_type")
@DiscriminatorValue("Candy")
public abstract class Candy extends Tracked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @Enumerated(EnumType.STRING)
    private CandyColor color;

    public Long getId() {
        return id;
    }

    public CandyColor getColor() {
        return color;
    }

    public void setColor(CandyColor color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
