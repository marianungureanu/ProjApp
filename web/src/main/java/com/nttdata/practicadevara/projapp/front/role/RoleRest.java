package com.nttdata.practicadevara.projapp.front.role;

import com.nttdata.practicadevara.projapp.front.RestClient;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
public class RoleRest extends RestClient {

    private int tempIndex = 0;           //to be delete when REST services are ready
    private List<RoleDto> tempList;  //to be delete when REST services are ready

    @PostConstruct
    public void init() {
        tempList = new ArrayList<>();
        
        Response resp = super.path("role").request(MediaType.APPLICATION_JSON).get(Response.class);
        tempList.addAll(resp.readEntity(new GenericType<List<RoleDto>>(){}));
    }

    public List<RoleDto> listRoles() {
        return tempList;
    }

    public RoleDto update(RoleDto entry) {
        return entry;
    }

    public RoleDto create(RoleDto entry) {
        entry.setId(tempIndex++);
        tempList.add(entry);
        return entry;
    }

    List<RoleDto> listRoleDto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
