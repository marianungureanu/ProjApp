package com.nttdata.practicadevara.projapp.front.employee;

import com.nttdata.practicadevara.projapp.front.RestClient;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
public class EmployeeRest extends RestClient {

    private int tempIndex = 0;           //to be delete when REST services are ready
    private List<EmployeeDto> tempList;  //to be delete when REST services are ready

    @PostConstruct
     public void init() {
        tempList = new ArrayList<>();
        
        Response resp = super.path("employee").request(MediaType.APPLICATION_JSON).get(Response.class);
        tempList.addAll(resp.readEntity(new GenericType<List<EmployeeDto>>(){}));
    }


    public List<EmployeeDto> listEmployees() {
        return tempList;
    }

    public EmployeeDto update(EmployeeDto entry) {
        return entry;
    }

    public EmployeeDto create(EmployeeDto entry) {
        entry.setId(tempIndex++);
        tempList.add(entry);
        return entry;
    }
}
