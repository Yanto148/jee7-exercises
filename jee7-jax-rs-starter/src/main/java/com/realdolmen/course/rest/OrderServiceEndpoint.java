package com.realdolmen.course.rest;

import com.realdolmen.course.domain.Order;
import com.realdolmen.course.service.OrderServiceBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Stateless
@Path("/orders")
@Produces({MediaType.APPLICATION_XML})
public class OrderServiceEndpoint
{
    @EJB
    OrderServiceBean orderService;

    @GET
    public List<Order> findAll()
    {
        return orderService.findAll();
    }
}
