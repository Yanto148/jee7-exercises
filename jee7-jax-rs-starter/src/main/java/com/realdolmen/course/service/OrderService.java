package com.realdolmen.course.service;

import com.realdolmen.course.domain.Order;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface OrderService
{
    Order createOrder(long price);

    List<Order> findAll();

    Order findById(Long id);

    void remove(long id);
}
