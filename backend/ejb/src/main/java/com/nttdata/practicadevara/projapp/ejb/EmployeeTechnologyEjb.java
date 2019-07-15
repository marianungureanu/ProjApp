/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.shared.dto.EmployeeTechnologyDto;
import com.nttdata.practicadevara.projapp.db.EmployeetechnologyBean;
import com.nttdata.practicadevara.projapp.db.EmployeetechnologyEntity;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeTechnologyDto;
import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author sebabstian.stoica
 */
@Stateless
@LocalBean
public class EmployeeTechnologyEjb {

    @EJB
    private EmployeetechnologyBean employeeTechnologyDbBean;

    public List<EmployeeTechnologyDto> findById(int id) {
        List<EmployeetechnologyEntity> entity = employeeTechnologyDbBean.findById(id);
        return toDtoEmployeeTechnologyList(entity);
    }

    public EmployeeTechnologyDto create(EmployeeTechnologyDto dto) {
        EmployeetechnologyEntity emplteh = fromDto(dto);
        EmployeetechnologyEntity saved = employeeTechnologyDbBean.create(emplteh);
        return toDto(emplteh);
    }

    public List<EmployeeTechnologyDto> listRequest() {
        List<EmployeetechnologyEntity> reqEntities = employeeTechnologyDbBean.findAll();
        return toDtoEmployeeTechnologyList(reqEntities);
    }

    static EmployeeTechnologyDto toDto(EmployeetechnologyEntity t) {
        if (t != null) {
            return new EmployeeTechnologyDto(t.getId(), DtoUtility.toDto(t.getEmployee()), DtoUtility.toDto(t.getTechnology()), DtoUtility.toDto(t.getLevel()));
        }
        return new EmployeeTechnologyDto();
    }

    static EmployeetechnologyEntity fromDto(EmployeeTechnologyDto dto) {
        EmployeetechnologyEntity ret = new EmployeetechnologyEntity();
        if (dto != null) {
            ret.setId(dto.getId());
            ret.setEmployee(DtoUtility.fromDto(dto.getEmployee()));
            ret.setLevel(DtoUtility.fromDto(dto.getLevel()));
            ret.setTechnology(DtoUtility.fromDto(dto.getTechnology()));
        }
        return ret;
    }
}
