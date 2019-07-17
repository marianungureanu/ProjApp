package com.nttdata.practicadevara.projapp.front.employee;

import com.nttdata.practicadevara.projapp.front.RestClient;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
public class EmployeeRest extends RestClient {

    private static final String PATH_EMPLOYEE = "employee";

    public List<EmployeeDto> listEmployees() {
        Response resp = super.path("employee").request(MediaType.APPLICATION_JSON).get(Response.class);
        return resp.readEntity(new GenericType<List<EmployeeDto>>(){});
    }

    public EmployeeDto create(EmployeeDto entry) {
        Entity requestEntity = Entity.entity(entry, MediaType.APPLICATION_JSON);
        Response resp = super.path(PATH_EMPLOYEE).request(MediaType.APPLICATION_JSON).post(requestEntity);
        EmployeeDto ret = resp.readEntity(EmployeeDto.class);
        return ret;
    }
    
    public EmployeeDto update(EmployeeDto entry) throws ClientErrorException {
        Entity requestEntity = Entity.entity(entry, MediaType.APPLICATION_JSON);
        Response resp = super.path(PATH_EMPLOYEE).request(MediaType.APPLICATION_JSON).put(requestEntity);
        EmployeeDto ret = resp.readEntity(EmployeeDto.class);
        return ret;
    }
    
    public void delete(EmployeeDto entry) throws ClientErrorException {
        Response resp = super.path(PATH_EMPLOYEE + "/" + entry.getId()).request(MediaType.APPLICATION_JSON).delete();
        if(resp.getStatus() > 300) {
            throw new ClientErrorException("Error deleting employee "+entry.getId()+": "+resp.getStatusInfo(), resp);
        }
    }
}
