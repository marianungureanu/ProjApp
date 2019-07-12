package com.nttdata.practicadevara.projapp.front.technology;

import com.nttdata.practicadevara.projapp.front.RestClient;
import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
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
public class TechnologyRest extends RestClient {

    private int tempIndex = 0;           //to be delete when REST services are ready
    private List<TechnologyDto> tempList;  //to be delete when REST services are ready

    @PostConstruct
    public void init() {
        tempList = new ArrayList<>();
        
        Response resp = super.path("technology").request(MediaType.APPLICATION_JSON).get(Response.class);
        tempList.addAll(resp.readEntity(new GenericType<List<TechnologyDto>>(){}));
    }

    public List<TechnologyDto> listTechnologies() {
        return tempList;
    }

    public TechnologyDto update(TechnologyDto entry) {
        return entry;
    }

    public TechnologyDto create(TechnologyDto entry) {
        entry.setId(tempIndex++);
        tempList.add(entry);
        return entry;
    }
    
       public void delete(TechnologyDto entry) {
        tempList.remove(entry);
    }
}
