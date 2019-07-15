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
public class LevelRest extends RestClient {

    private int tempIndex = 0;         //to be delete when REST services are ready
    private List<LevelDto> tempList;  //to be delete when REST services are ready

    @PostConstruct
    public void init() {
        tempList = new ArrayList<>();
        
        Response resp = super.path("level").request(MediaType.APPLICATION_JSON).get(Response.class);
        tempList.addAll(resp.readEntity(new GenericType<List<LevelDto>>(){}));
    }

    public List<LevelDto> listLevel() {
        return tempList;
    }

    public LevelDto update(LevelDto entry) {
        return entry;
    }

    public LevelDto create(LevelDto entry) {
        entry.setId(tempIndex++);
        tempList.add(entry);
        return entry;
    }
}
