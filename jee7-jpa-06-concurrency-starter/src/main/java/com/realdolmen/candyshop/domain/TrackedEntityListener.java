package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.util.UserUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class TrackedEntityListener {
    // TODO: add an entity listener method to update userCreated and userModified before saving. Use currentUser()
    @PrePersist
    public void initUserCreated(Tracked t)
    {
        t.setUserCreated(currentUser());
    }

    // TODO: add an entity listener method to update userModified before updating. Use currentUser()
    @PreUpdate
    public void initUserModified(Tracked t)
    {
        t.setUserModified(currentUser());
    }

    private String currentUser() {
        return UserUtils.currentUser();
    }
}
