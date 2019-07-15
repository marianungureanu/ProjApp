/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.rest.services;


import com.nttdata.practicadevara.projapp.db.EmployeetechnologyEntity;
import com.nttdata.practicadevara.projapp.ejb.EmployeeTechnologyEjb;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeTechnologyDto;
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


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;


/**
 *
 * @author sebastian.stoica
 */

/**
 * REST Web Service for user
 */
@Path("/employeetechnology")
@Stateless
@LocalBean
public class ServicesEmpTech {
    
    @EJB
    private EmployeeTechnologyEjb EmployeeTechnologyEjb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesEmpTech() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUserValues() {
        List<EmployeeTechnologyDto> EmpTech = EmployeeTechnologyEjb.listRequest();
        return Response.ok(EmpTech).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id,
        @Context HttpServletRequest servletRequest) {
        List<EmployeeTechnologyDto> employee = EmployeeTechnologyEjb.findById(id);
        return Response.ok(employee).build();
    }

  

}