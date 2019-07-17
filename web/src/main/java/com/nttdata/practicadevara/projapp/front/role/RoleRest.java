package com.nttdata.practicadevara.projapp.front.role;

import com.nttdata.practicadevara.projapp.front.RestClient;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
public class RoleRest extends RestClient {

    private static final String PATH_APPLICATION = "role";

    public List<RoleDto> listRoles() {
        Response resp = super.path("role").request(MediaType.APPLICATION_JSON).get(Response.class);
        return resp.readEntity(new GenericType<List<RoleDto>>() {
        });
    }

    public RoleDto update(RoleDto entry) throws javax.ws.rs.ClientErrorException {
        Response resp = super.path(PATH_APPLICATION).request(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
        RoleDto ret = resp.readEntity(RoleDto.class);
        return ret;
    }

    public RoleDto create(RoleDto entry) {
        Entity<RoleDto> obj = Entity.entity(entry, MediaType.APPLICATION_JSON);
        Response resp = super.path("role").request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(obj);
        return resp.readEntity(new GenericType<RoleDto>() {
        });
    }

    List<RoleDto> listRoleDto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
