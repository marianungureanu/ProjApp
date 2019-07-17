package com.nttdata.practicadevara.projapp.rest.services;

import com.nttdata.practicadevara.projapp.db.DbException;
import com.nttdata.practicadevara.projapp.ejb.RoleEjb;
import com.nttdata.practicadevara.projapp.shared.dto.BackendException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id,
            @Context HttpServletRequest servletRequest) {
        RoleDto role = roleEjb.findById(id);
        return Response.ok(role).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RoleDto update(RoleDto app) throws BackendException {
        try {
            return roleEjb.update(app);
        } catch (DbException ex) {
            Logger.getLogger(ServicesRole.class.getName()).log(Level.SEVERE, null, ex);
            throw new BackendException(ex.getMessage());
        }
    }
}
