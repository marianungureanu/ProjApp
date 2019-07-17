/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.front.levels;

/**
 *
 * @author larisa.marin
 */
import com.nttdata.practicadevara.projapp.front.RestClient;
import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@LocalBean
public class LevelRest extends RestClient {

    public List<LevelDto> listLevel() {
        Response resp = super.path("level").request(MediaType.APPLICATION_JSON).get(Response.class);
        return resp.readEntity(new GenericType<List<LevelDto>>() {
        });
    }

    public LevelDto update(LevelDto entry) {
        Entity<LevelDto> obj = Entity.entity(entry, MediaType.APPLICATION_JSON);
        Response resp = super.path("level").request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).put(obj);
        return resp.readEntity(new GenericType<LevelDto>() {
        });
    }

    public LevelDto create(LevelDto entry) {
        Entity<LevelDto> obj = Entity.entity(entry, MediaType.APPLICATION_JSON);
        Response resp = super.path("level").request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(obj);
        return resp.readEntity(new GenericType<LevelDto>() {
        });
    }
    
    public void delete(LevelDto entry) {
        Response resp = super.path("level").path(Integer.toString(entry.getId())).request(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).delete();
    }
}
