package com.realdolmen.course.service;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.Customer;
import com.realdolmen.course.repository.CustomerRepository;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class CustumerServiceBean implements CustumerService {

    @Inject
    private CustomerRepository customerRepository;

    @Override
    public void createCustomer(String name, Address address)
    {
        Customer customer = new Customer(name, address);
        customerRepository.createCustomer(name, address);
    }

    @Override
    public Customer findById(Integer id)
    {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByName(String name)
    {
        return customerRepository.findByName(name);
    }
}
