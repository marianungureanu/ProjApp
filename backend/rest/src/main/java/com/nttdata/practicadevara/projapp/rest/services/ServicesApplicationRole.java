/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.rest.services;

import com.nttdata.practicadevara.projapp.ejb.ApplicationRoleEjb;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author liviu.dima
 */

@Path("/applicationrole")
@Stateless
@LocalBean
public class ServicesApplicationRole {
    @EJB
    private ApplicationRoleEjb applicationRole;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesApplicationRole() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<ApplicationRoleDto> apps = applicationRole.list();
        return Response.ok(apps).build();
    }
}
