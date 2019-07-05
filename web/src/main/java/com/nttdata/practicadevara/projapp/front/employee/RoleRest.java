/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.front.employee;

import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author liviu.dima
 */
public class RoleRest {
     private int tempIndex = 0;           //to be delete when REST services are ready
    private List<RoleDto> tempList;  //to be delete when REST services are ready
    List<RoleDto> listRole;

    @PostConstruct
    public void init() {
        tempList = new ArrayList<>();
        for(int i=0; i<5; i++) { 
            RoleDto e = new RoleDto(tempIndex,"Role");
            tempList.add(e);
        }
    }
    public List<RoleDto> listRole() {
        return tempList;
    }
}
