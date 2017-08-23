package com.realdolmen.course.service;

import com.realdolmen.course.domain.Address;
import com.realdolmen.course.domain.Customer;

import java.util.List;

public interface CustumerService {
    void createCustomer(String name, Address address);

    Customer findById(Integer id);

    List<Customer> findAll();

    Customer findByName(String name);
}
