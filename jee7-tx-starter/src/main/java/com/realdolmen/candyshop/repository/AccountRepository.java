package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Account;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

// TODO This should be a SLSB...
@Stateless
public class AccountRepository implements Serializable {

    // TODO Retrieve the EntityManager
    @PersistenceContext
    EntityManager em;

    public Account save(Account account) {
        return em.merge(account);
    }

    public List<Account> findAll() {
        return em.createQuery("select a from Account a", Account.class).getResultList();
    }

    public void removeAllAccounts() {
        em.createQuery("delete from Account").executeUpdate();
    }
}
