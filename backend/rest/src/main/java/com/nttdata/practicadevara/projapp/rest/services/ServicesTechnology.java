/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.rest.services;

import com.nttdata.practicadevara.projapp.db.DbException;
import com.nttdata.practicadevara.projapp.ejb.TechnologyEjb;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import javax.ejb.EJB;
import java.util.List;
import javax.ws.rs.core.Response;

import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 *
 * @author stefana.sireanu
 */

/**
 * REST Web Service for user
 */
@Path("/technology")
@Stateless
@LocalBean
public class ServicesTechnology {
    
    @EJB
    private TechnologyEjb technologyEjb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesTechnology() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUserValues() {
        List<TechnologyDto> technology = technologyEjb.list();
        return Response.ok(technology).build();        
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id,
            @Context HttpServletRequest servletRequest) {
        TechnologyDto technology = technologyEjb.findById(id);
        return Response.ok(technology).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postnewTechnology(TechnologyDto e) {
        TechnologyDto technology = technologyEjb.create(e);
        return Response.ok(technology).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteTechnology(@PathParam("id") int id) throws DbException {
        technologyEjb.delete(id);
        
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(TechnologyDto e) {
        TechnologyDto technology = technologyEjb.edit(e);
        return Response.ok(technology).build();
    }
 }
