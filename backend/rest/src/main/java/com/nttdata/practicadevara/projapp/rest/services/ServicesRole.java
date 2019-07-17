package com.nttdata.practicadevara.projapp.rest.services;

import com.nttdata.practicadevara.projapp.ejb.RoleEjb;
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

import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.POST;


/**
 * REST Web Service for user
 */
@Path("/role")
@Stateless
@LocalBean
public class ServicesRole {

    @EJB
    private RoleEjb roleEjb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesRole() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUserValues() {
        List<RoleDto> roles = roleEjb.list();
        return Response.ok(roles).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newRole(RoleDto e) {
        RoleDto res = roleEjb.create(e);
        return Response.ok(res).build();
    }
}