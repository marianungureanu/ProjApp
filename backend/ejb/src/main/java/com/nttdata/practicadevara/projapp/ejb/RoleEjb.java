/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.db.RoleBean;
import com.nttdata.practicadevara.projapp.db.RoleEntity;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author ovidiu.hulea
 */
@Stateless
@LocalBean
public class RoleEjb {

    @EJB
    private RoleBean roleDbBean;
    
    public List<RoleDto> list() {
        List<RoleEntity> entities = roleDbBean.findAll();
        return toDto(entities);
    }
    
    private List<RoleDto> toDto(List<RoleEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
     
    private RoleDto toDto(RoleEntity e) {
        RoleDto roleDto = null;
        if (e != null) {
            roleDto = new RoleDto(e.getId(), e.getName());
        }
        return roleDto;
    }

    private RoleEntity fromDto(RoleDto dto) {
        RoleEntity e = new RoleEntity();
        e.setId(dto.getId());
        e.setName(dto.getName());
        return e;
    }
}
