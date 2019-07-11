/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.rest.services;

import com.nttdata.practicadevara.projapp.db.ApplicationRolesTechnologiesEntity;
import com.nttdata.practicadevara.projapp.ejb.ApplicationRolesTechnologiesEjb;
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

import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleTechnologyDto;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;
/**
 *
 * @author iulia.rinea
 */

/**
 * REST Web Service for user
 */
@Path("/applicationrolestechnologies")
@Stateless
@LocalBean
public class ServicesAppRolesTechnologies {
    
     @EJB
    private ApplicationRolesTechnologiesEjb appRolesTechEjb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesAppRolesTechnologies() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUserValues() {
        List<ApplicationRolesTechnologiesEntity> employees = appRolesTechEjb.list();
        return Response.ok(employees).build();
    }
    
    
    
    
    
}
