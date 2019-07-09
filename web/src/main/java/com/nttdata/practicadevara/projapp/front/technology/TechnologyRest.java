package com.nttdata.practicadevara.projapp.front.technology;

import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TechnologyRest {

    private int tempIndex = 0;           //to be delete when REST services are ready
    private List<TechnologyDto> tempList;  //to be delete when REST services are ready

    @PostConstruct
    public void init() {
        tempList = new ArrayList<>();
        for(int i=0; i<5; i++) { 
            TechnologyDto e = new TechnologyDto(tempIndex++, "Technology " + tempIndex);
            tempList.add(e);
        }
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
}
