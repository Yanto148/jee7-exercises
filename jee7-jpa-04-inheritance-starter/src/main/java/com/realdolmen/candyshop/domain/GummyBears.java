package com.realdolmen.candyshop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: make a sublcass entity of candy (use table name 'gummy_bears'), add discriminators
@Entity
@Table(name = "gummy_bears")
@DiscriminatorValue("gummy")
public class GummyBears extends Candy {
    // TODO: add flavour property (String)
    private String flavour;

    public String getFlavour() {
        return flavour;
    }
}
