package com.nttdata.practicadevara.projapp.front.employee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author liviu.dima
 */
public class ApplicationRoleRest {
     private int tempIndex = 0;           //to be delete when REST services are ready
    private List<ApplicationRoleDto> tempList;  //to be delete when REST services are ready
    List<ApplicationRoleDto> listApplicationRole;

    @PostConstruct
    public void init() {
        tempList = new ArrayList<>();
        for(int i=0; i<5; i++) { 
            ApplicationRoleDto e = new ApplicationRoleDto(tempIndex++,tempIndex,tempIndex);
            tempList.add(e);
        }
    }
    public List<ApplicationRoleDto> listApplicationRole() {
        return tempList;
    }
}
