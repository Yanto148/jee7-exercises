package com.realdolmen.candyshop.domain;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@EntityListeners(TrackedEntityListener.class)
@MappedSuperclass
public class Tracked {
    private String userCreated;

    // TODO: add userModified field (String)
    private String userModified;

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public String getUserModified() {
        return userModified;
    }

    public void setUserModified(String userModified) {
        this.userModified = userModified;
    }
}
