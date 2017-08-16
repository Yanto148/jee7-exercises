package com.realdolmen.candyshop.integration;

import com.realdolmen.candyshop.AbstractRemoteIntegrationTest;
import com.realdolmen.candyshop.domain.Account;
import com.realdolmen.candyshop.domain.Bug;
import com.realdolmen.candyshop.service.BankRemote;
import com.realdolmen.candyshop.utils.BankProducers;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.NamingException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by cda5732 on 1/03/2017.
 */
public class BankIntegrationTest extends AbstractRemoteIntegrationTest {

    private static BankRemote bank;

    @BeforeClass
    public static void init() throws NamingException {
        // TODO Look up the BankRemote
        bank = lookup("jee7-tx-starter/Bank!com.realdolmen.candyshop.service.BankRemote");
    }

    @Test
    public void transferMoneyBetweenAccounts() {
        System.out.println();

        System.out.println("Opening accounts");
        System.out.println("----------------");
        Account checking = bank.openAccount(new Account("Checking account"));
        System.out.println("Opening account " + checking.getName() + " with balance €" + checking.getBalance());
        Account savings = bank.openAccount(new Account("Savings account"));
        System.out.println("Opening account " + savings.getName() + " with balance €" + savings.getBalance());


        try {
            System.out.println();
            System.out.println("Performing financial transactions");
            System.out.println("---------------------------------");
            BigDecimal initial = new BigDecimal("1000");
            checking = bank.transfer(initial, checking);
            System.out.format("Transfering €%s to '%s'%n", initial.toString(), checking.getName());

            BigDecimal transfer = new BigDecimal("250");
            savings = bank.transfer(transfer, checking, savings);
            System.out.format("Transfering €%s from account '%s' to '%s'%n", transfer.toString(), checking.getName(), savings.getName());

        } catch(Bug b) {
            b.printStackTrace(System.out);
        } finally {
            System.out.println();
            System.out.println("Printing account balances");
            System.out.println("-------------------------");
            printAccounts();
        }

        bank.removeAllAccounts();

        System.out.println();
    }

    public void printAccounts() {
        List<Account> accounts = bank.findAll();
        accounts.forEach(Account::print);
        BigDecimal total = accounts.stream().map(Account::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total money: " + total);
    }
}
