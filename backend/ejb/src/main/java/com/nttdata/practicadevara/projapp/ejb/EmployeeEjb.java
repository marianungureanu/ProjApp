package com.nttdata.practicadevara.projapp.ejb;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;
import com.nttdata.practicadevara.projapp.db.EmployeeEntity;
import com.nttdata.practicadevara.projapp.db.EmployeeBean;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
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
            empDto = new EmployeeDto(e.getId(), e.getName());
        }
        return empDto;
    }

    private EmployeeEntity fromDto(EmployeeDto dto) {
        EmployeeEntity e = new EmployeeEntity();
        e.setId(dto.getId());
        e.setName(dto.getName());
        return e;
    }
    
}
