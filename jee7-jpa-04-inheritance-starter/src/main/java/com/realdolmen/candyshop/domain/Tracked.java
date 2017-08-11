package com.realdolmen.candyshop.domain;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

// TODO: Make into a mapped superclass, not an entity!
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Tracked {
    // TODO: add property userCreated (String)
    private String userCreated;

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }
}
