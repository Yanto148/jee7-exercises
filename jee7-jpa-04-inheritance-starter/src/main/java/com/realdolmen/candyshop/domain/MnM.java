package com.realdolmen.candyshop.domain;

import javax.persistence.*;

// TODO: make a sublcass entity of candy, add discriminators
@Entity
@DiscriminatorValue("m&m")
public class MnM extends Candy {
    // TODO: add property nuts (boolean)

    private boolean nuts;

    public boolean isNuts() {
        return nuts;
    }
}
