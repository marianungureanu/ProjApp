/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.rest.services;

import com.nttdata.practicadevara.projapp.db.DbException;
import com.nttdata.practicadevara.projapp.ejb.SubscriptionEjb;
import com.nttdata.practicadevara.projapp.shared.dto.BackendException;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionDto;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionStatusEnumDto;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import javax.ejb.EJB;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

/**
 *
 * @author eduard.ioo
 */
@Path("/subscription")
@Stateless
@LocalBean
public class ServicesSubscription {

    @EJB
    private SubscriptionEjb subscriptionEjb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesSubscription() {
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getSubscriptions(@PathParam("id") int appRoleId, @QueryParam("employeeId") int employeeId) {
        List<SubscriptionDto> subscription = subscriptionEjb.list(appRoleId, employeeId);
        return Response.ok(subscription).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllSubscriptions() {
        List<SubscriptionDto> subscription = subscriptionEjb.listAll();
        return Response.ok(subscription).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SubscriptionDto update(SubscriptionDto subscriptionDto) throws BackendException {
        try {
            return subscriptionEjb.update(subscriptionDto);
        } catch (DbException ex) {
            Logger.getLogger(ServicesSubscription.class.getName()).log(Level.SEVERE, null, ex);
            throw new BackendException(ex.getMessage());
        }
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newSubscription(SubscriptionDto subscription) {
        SubscriptionDto res = subscriptionEjb.create(subscription);
        return Response.ok(res).build();
    }
}
