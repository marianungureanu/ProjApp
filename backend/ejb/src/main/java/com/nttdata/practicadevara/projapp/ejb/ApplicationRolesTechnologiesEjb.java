package com.nttdata.practicadevara.projapp.ejb;

import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import java.util.List;

import com.nttdata.practicadevara.projapp.db.ApplicationRolesTechnologiesEntity;
import com.nttdata.practicadevara.projapp.db.ApplicationRolesTechnologiesBean;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleTechnologyDto;
import javax.ejb.EJB;

@Stateless
@LocalBean
/**
 *
 * @author iulia.rinea
 */
public class ApplicationRolesTechnologiesEjb {

    @EJB
    private ApplicationRolesTechnologiesBean appDbBean;

    public List<ApplicationRoleTechnologyDto> list() {
        List<ApplicationRolesTechnologiesEntity> entities = appDbBean.findAll();
        return toDtoApplicationRolesTechnologiesList(entities);
    }

//    public EmployeeEntity create(EmployeeEntity dto) {
//        EmployeeEntity e = fromDto(dto);
//        EmployeeEntity entity = employeeDbBean.create(e);
//        return toDto(entity);
//    }
}
