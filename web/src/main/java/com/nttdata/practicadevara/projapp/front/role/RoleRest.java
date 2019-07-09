package com.nttdata.practicadevara.projapp.front.role;

import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class RoleRest {

    private int tempIndex = 0;           //to be delete when REST services are ready
    private List<RoleDto> tempList;  //to be delete when REST services are ready

    @PostConstruct
    public void init() {
        tempList = new ArrayList<>();
        for(int i=0; i<5; i++) { 
            RoleDto e = new RoleDto(tempIndex++, "Role " + tempIndex);
            tempList.add(e);
        }
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
}
