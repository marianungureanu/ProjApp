package com.nttdata.practicadevara.projapp.rest.services;

import com.nttdata.practicadevara.projapp.db.DbException;
import com.nttdata.practicadevara.projapp.ejb.ApplicationEjb;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationDto;
import com.nttdata.practicadevara.projapp.shared.dto.BackendException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/application")
@Stateless
@LocalBean
public class ServicesApplication {

    @EJB
    private ApplicationEjb applicationEjb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesApplication() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<ApplicationDto> apps = applicationEjb.list();
        return Response.ok(apps).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(ApplicationDto app) throws BackendException {
        try{
            ApplicationDto res = applicationEjb.create(app);
            return Response.ok(res).build();
        } catch (DbException ex) {
            Logger.getLogger(ServicesApplication.class.getName()).log(Level.SEVERE, null, ex);
            throw new BackendException(ex.getMessage());
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ApplicationDto update(ApplicationDto app) throws BackendException {
        try {
            return applicationEjb.update(app);
        } catch (DbException ex) {
            Logger.getLogger(ServicesApplication.class.getName()).log(Level.SEVERE, null, ex);
            throw new BackendException(ex.getMessage());
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) throws DbException {
        applicationEjb.delete(id);
        return Response.ok().build();
    }
}
