package com.realdolmen.candyshop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// TODO: make entity with table "oder_line"
@Entity
@Table(name = "order_line")
public class OrderLine {
    // TODO: add id (pk, generated) and quantity (int) properties
    @Id
    @GeneratedValue
    private Long id;

    private int quantity;

    // TODO: add a many to one association to candy
    @ManyToOne
    private Candy candy;

    public double calculateSubTotal() {
        // TODO: implement this method
        return quantity * candy.getPrice();
    }

    public Candy getCandy() {
        return candy;
    }
}
