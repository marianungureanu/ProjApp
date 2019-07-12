/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.rest.services;

import com.nttdata.practicadevara.projapp.ejb.LevelEjb;
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

import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.POST;

/**
 *
 * @author emanuel.butoi
 */
@Path("/level")
@Stateless
@LocalBean
public class ServicesLevel {

    @EJB
    private LevelEjb levelEjb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesLevel() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLevels() {
        List<LevelDto> levels = levelEjb.list();
        return Response.ok(levels).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newLevel(LevelDto e) {
        LevelDto res = levelEjb.create(e);
        return Response.ok(res).build();
    }

}
