package com.realdolmen.course.rest;

import com.realdolmen.course.domain.Order;
import com.realdolmen.course.service.OrderServiceBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    @DELETE
    @Path("{id}")
    public Response deleteOrder(@PathParam("id") long id)
    {
        Response.ResponseBuilder builder;

        Order order = orderService.findById(id);
        if (order == null)
            return Response.status(404).build();
        else
        {
            orderService.remove(id);
            return Response.ok().build();
        }
    }
}
