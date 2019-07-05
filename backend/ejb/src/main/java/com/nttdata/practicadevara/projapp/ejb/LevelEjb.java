/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.db.LevelBean;
import com.nttdata.practicadevara.projapp.db.LevelEntity;
import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
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
public class LevelEjb {

    @EJB
    private LevelBean levelDbBean;
    
    public List<LevelDto> list() {
        List<LevelEntity> entities = levelDbBean.findAll();
        return toDto(entities);
    }
    
    private List<LevelDto> toDto(List<LevelEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
     
    private LevelDto toDto(LevelEntity e) {
        LevelDto lvlDto = null;
        if (e != null) {
            lvlDto = new LevelDto(e.getId(), e.getName());
        }
        return lvlDto;
    }

    private LevelEntity fromDto(LevelDto dto) {
        LevelEntity e = new LevelEntity();
        e.setId(dto.getId());
        e.setName(dto.getName());
        return e;
    }
}
