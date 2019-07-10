/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.db.ApplicationEntity;
import com.nttdata.practicadevara.projapp.db.ApplicationRoleEntity;
import com.nttdata.practicadevara.projapp.db.ApplicationroleBean;
import com.nttdata.practicadevara.projapp.db.RoleEntity;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author liviu.dima
 */
@Stateless
@LocalBean
public class ApplicationRoleEjb {

    @EJB
    private ApplicationroleBean applicationRoleDbBean;

    public List<ApplicationRoleDto> list() {
        List<ApplicationRoleEntity> entities = applicationRoleDbBean.findAll();
        return toDto(entities);
    }

    private List<ApplicationRoleDto> toDto(List<ApplicationRoleEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    private ApplicationRoleDto toDto(ApplicationRoleEntity e) {
        ApplicationRoleDto applDto = null;
        if (e != null) {
            applDto = new ApplicationRoleDto(e.getId(), toDto(e.getApp()), toDto(e.getRole()));
        }
        return applDto;
    }
    
    private ApplicationDto toDto(ApplicationEntity e) {
        ApplicationDto applDto = null;
        if (e != null) {
            applDto = new ApplicationDto(e.getId(), e.getName(), e.getDescr());
        }
        return applDto;
    }
    
    private RoleDto toDto(RoleEntity e) {
        RoleDto applDto = null;
        if (e != null) {
            applDto = new RoleDto(e.getId(), e.getName());
        }
        return applDto;
    }

    private ApplicationRoleEntity fromDto(ApplicationRoleDto dto) {
        ApplicationRoleEntity e = new ApplicationRoleEntity();
        e.setId(dto.getId());
        e.setApp(fromDto(dto.getApp()));
        e.setRole(fromDto(dto.getRole()));
        return e;
    }
    
     private ApplicationEntity fromDto(ApplicationDto dto) {
        ApplicationEntity e = new ApplicationEntity();
        e.setId(dto.getId());
        e.setName(dto.getName());
        e.setDescr(dto.getDescription());
        return e;
    }
     
     private RoleEntity fromDto(RoleDto dto) {
        RoleEntity e = new RoleEntity();
        e.setId(dto.getId());
        e.setName(dto.getName());
        return e;
    }
}
