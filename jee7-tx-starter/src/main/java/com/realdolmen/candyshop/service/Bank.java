package com.realdolmen.candyshop.service;

import com.realdolmen.candyshop.domain.Account;
import com.realdolmen.candyshop.domain.Bug;
import com.realdolmen.candyshop.repository.AccountRepository;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

// TODO This should be a SLSB with remote access
@Remote
@Stateless
public class Bank implements BankRemote {
    // TODO Retrieve the AccountRepository
    @Inject
    private AccountRepository repository;

    @Override
    public Account openAccount(Account account) {
        return repository.save(account);
    }

    @Override
    public Account transfer(BigDecimal amount, Account from, Account to) throws Bug {

        from.setBalance(from.getBalance().subtract(amount));
        from = repository.save(from);

        // TODO Uncomment the Bug below to see if you handle transactions correctly
        Bug.causeMischief("i like it");

        to.setBalance(to.getBalance().add(amount));
        return repository.save(to);
    }

    @Override
    public Account transfer(BigDecimal amount, Account to) {
        to.setBalance(to.getBalance().add(amount));
        return repository.save(to);
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public void removeAllAccounts() {
        repository.removeAllAccounts();
    }


}
