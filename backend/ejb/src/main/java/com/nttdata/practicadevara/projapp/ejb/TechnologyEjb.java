/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.db.TechnologyEntity;
import com.nttdata.practicadevara.projapp.db.TechnologyBean;
import com.nttdata.practicadevara.projapp.db.TechnologyEntity;
import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author liviu.dima
 */
@Stateless
@LocalBean
public class TechnologyEjb {

    @EJB
    private TechnologyBean technologyDbBean;
    
    public List<TechnologyDto> list() {
        List<TechnologyEntity> entities = technologyDbBean.findAll();
        return toDto(entities);
    }
    
     public TechnologyDto findById(int id) {
        TechnologyEntity entity = technologyDbBean.findById(id);
        return toDto(entity);
    }
    
    private List<TechnologyDto> toDto(List<TechnologyEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
     
    private TechnologyDto toDto(TechnologyEntity e) {
        TechnologyDto empDto = null;
        if (e != null) {
            empDto = new TechnologyDto(e.getId(), e.getName());
        }
        return empDto;
    }

    private TechnologyEntity fromDto(TechnologyDto dto) {
        TechnologyEntity e = new TechnologyEntity();
        e.setId(dto.getId());
        e.setName(dto.getName());
        return e;
    } 
    
}
