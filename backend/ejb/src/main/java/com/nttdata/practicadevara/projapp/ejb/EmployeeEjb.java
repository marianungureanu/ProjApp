package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.db.DbException;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;
import com.nttdata.practicadevara.projapp.db.EmployeeEntity;
import com.nttdata.practicadevara.projapp.db.EmployeetechnologyEntity;
import com.nttdata.practicadevara.projapp.db.EmployeeBean;

import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeTechnologyDto;
import java.util.Collections;
import java.util.stream.Collectors;
import javax.ejb.EJB;


@Stateless
@LocalBean
public class EmployeeEjb {

    @EJB
    private EmployeeBean employeeDbBean;
    

    public List<EmployeeDto> list() {
        List<EmployeeEntity> entities = employeeDbBean.findAll();
        return toDto(entities);
    }

    public EmployeeDto findById(int id) {
        EmployeeEntity entity = employeeDbBean.findById(id);
        return toDto(entity);
    }
    
    private List<EmployeeDto> toDto(List<EmployeeEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    private EmployeeDto toDto(EmployeeEntity e) {
        EmployeeDto empDto = null;
        if (e != null) {
            empDto = new EmployeeDto(e.getId(), e.getName(),toDtoEmployeeTechnologyList(e.getSkills()));
        }
        return empDto;
    }
    
  


    private EmployeeEntity fromDto(EmployeeDto dto) {
        EmployeeEntity e = new EmployeeEntity();
        e.setId(dto.getId());
        e.setName(dto.getName());
        e.setSkills(fromDtoEmployeeTechnologyList(dto.getSkills()));
        return e;
    }

    public EmployeeDto create(EmployeeDto dto) {
        EmployeeEntity emp = fromDto(dto);
        EmployeeEntity saved = employeeDbBean.create(emp);
        return toDto(saved);
    }
    
   
    
     public EmployeeDto edit(EmployeeDto dto) throws DbException {
        //EmployeeEntity entity = employeeDbBean.findById(dto.getId());
        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSkills(fromDtoEmployeeTechnologyList(dto.getSkills()));
        entity.setEmployeeInSkills();
   
        EmployeeEntity e = employeeDbBean.edit(entity);
        return toDto(e);
    }
     
     
  
} 
    
     
  
