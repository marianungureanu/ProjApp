package com.nttdata.practicadevara.projapp.rest.services;

import com.nttdata.practicadevara.projapp.db.DbException;
import com.nttdata.practicadevara.projapp.ejb.EmployeeEjb;
import com.nttdata.practicadevara.projapp.shared.dto.BackendException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import javax.ejb.EJB;
import java.util.List;
import javax.ws.rs.core.Response;

import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service for user
 */
@Path("/employee")
@Stateless
@LocalBean
public class ServicesEmployee {

    @EJB
    private EmployeeEjb employeeEjb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WebServices
     */
    public ServicesEmployee() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUserValues() {
        List<EmployeeDto> employees = employeeEjb.list();
        return Response.ok(employees).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id,
            @Context HttpServletRequest servletRequest) {
        EmployeeDto res = employeeEjb.findById(id);
        return Response.ok(res).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newEmployee(EmployeeDto employee) {
        EmployeeDto res = employeeEjb.create(employee);
        return Response.ok(res).build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public EmployeeDto update(EmployeeDto emp) throws BackendException {
        try {
            return employeeEjb.edit(emp);
        } catch (DbException ex) {
            Logger.getLogger(ServicesEmployee.class.getName()).log(Level.SEVERE, null, ex);
            throw new BackendException(ex.getMessage());
        }
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") int id,
            @Context HttpServletRequest servletRequest) {
        employeeEjb.deleteById(id);
    }
    

    
    
    
}
