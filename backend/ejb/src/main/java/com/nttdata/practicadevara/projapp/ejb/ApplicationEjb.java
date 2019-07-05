/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.db.ApplicationBean;
import com.nttdata.practicadevara.projapp.db.ApplicationEntity;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationDto;
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
public class ApplicationEjb {

    @EJB
    private ApplicationBean applicationDbBean;
    
    public List<ApplicationDto> list() {
        List<ApplicationEntity> entities = applicationDbBean.findAll();
        return toDto(entities);
    }
    
    private List<ApplicationDto> toDto(List<ApplicationEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
     
    private ApplicationDto toDto(ApplicationEntity e) {
        ApplicationDto applDto = null;
        if (e != null) {
            applDto = new ApplicationDto(e.getId(), e.getName(),e.getDescr());
        }
        return applDto;
    }

    private ApplicationEntity fromDto(ApplicationDto dto) {
        ApplicationEntity e = new ApplicationEntity();
        e.setId(dto.getId());
        e.setName(dto.getName());
        e.setDescr(dto.getDescr());
        return e;
    }
}
