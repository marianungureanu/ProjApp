package com.nttdata.practicadevara.projapp.front.application;

import com.nttdata.practicadevara.projapp.front.RestClient;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationDto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
public class ApplicationRest extends RestClient {
 
    private static final String PATH_APPLICATION = "application";
 
    public List<ApplicationDto> listApplications() throws javax.ws.rs.ClientErrorException {
        Response resp = super.path(PATH_APPLICATION).request(MediaType.APPLICATION_JSON).get(Response.class);
        List<ApplicationDto> ret = resp.readEntity(new GenericType<List<ApplicationDto>>() {
        });
        return ret;
    }

    public ApplicationDto update(ApplicationDto entry) throws javax.ws.rs.ClientErrorException {
        Response resp = super.path(PATH_APPLICATION).request(MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
        ApplicationDto ret = resp.readEntity(ApplicationDto.class);
        return ret;
    }

    public ApplicationDto create(ApplicationDto entry) throws javax.ws.rs.ClientErrorException {
        Response resp = super.path(PATH_APPLICATION).request(MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(entry, MediaType.APPLICATION_JSON), Response.class);
        ApplicationDto ret = resp.readEntity(ApplicationDto.class);
        return ret;
    }

    public Response delete(ApplicationDto entry) throws javax.ws.rs.ClientErrorException {
        Response resp = super.path(PATH_APPLICATION + "/" + entry.getId()).request(MediaType.APPLICATION_JSON).delete();
        return resp;
    }
}
