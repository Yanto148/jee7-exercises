package com.realdolmen.course.service;

import com.realdolmen.course.domain.Order;
import com.realdolmen.course.repository.OrderRepository;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
@LocalBean
public class OrderServiceBean implements OrderService
{
    @EJB
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(long price) {
        Order order = new Order();
        order.setPrice(price);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id);
    }
}
