/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;

import com.nttdata.practicadevara.projapp.db.ApplicationRolesTechnologiesEntity;
import com.nttdata.practicadevara.projapp.db.ApplicationRolesTechnologiesBean;
import com.nttdata.practicadevara.projapp.db.LevelEntity;
import com.nttdata.practicadevara.projapp.db.TechnologyEntity;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleTechnologyDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ws.rs.Path;


@Stateless
@LocalBean
/**
 *
 * @author iulia.rinea
 */
public class ApplicationRolesTechnologiesEjb {
    
       @EJB
    private ApplicationRolesTechnologiesBean appDbBean;
   
    
    public List<ApplicationRolesTechnologiesEntity> list() {
        List<ApplicationRolesTechnologiesEntity> entities = appDbBean.findAll();
       
        //return toDto(entities);
        return entities;
    }
    


//    public EmployeeEntity create(EmployeeEntity dto) {
//        EmployeeEntity e = fromDto(dto);
//        EmployeeEntity entity = employeeDbBean.create(e);
//        return toDto(entity);
//    }


    private List<ApplicationRoleTechnologyDto> toDto(List<ApplicationRolesTechnologiesEntity> list) {
        if (list != null) {
            //return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

  /*  private ApplicationRoleTechnologyDto toDto(ApplicationrolestechnologiesEntity e) {
        ApplicationRoleTechnologyDto empDto=null;
        
         
        if (e != null) {
            empDto = new ApplicationRoleTechnologyDto(e.getId(),techDto,levelDto);
        }
        return empDto;
    }*/

 
    
}
