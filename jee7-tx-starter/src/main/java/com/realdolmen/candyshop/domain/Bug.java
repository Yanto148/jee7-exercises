package com.realdolmen.candyshop.domain;

import javax.ejb.ApplicationException;

// TODO Place an annotation here if the Bug should rollback the transaction
@ApplicationException(rollback = true)
public class Bug extends Exception {
    public static void causeMischief(String why) throws Bug {
        throw new Bug(why);
    }

    private Bug(String why) {
        super(String.format("Causing mischief because %s", why));
    }
}
