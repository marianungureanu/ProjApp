package com.nttdata.practicadevara.projapp.ejb;

import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;

import com.nttdata.practicadevara.projapp.db.RoleBean;
import com.nttdata.practicadevara.projapp.db.RoleEntity;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;



@Stateless
@LocalBean
public class RoleEjb {

    @EJB
    private RoleBean roleDbBean;
    
    public List<RoleDto> list() {
        List<RoleEntity> entities = roleDbBean.findAll();
        return toDtoRoleList(entities);
    }
    
    public RoleDto create(RoleDto dto) {
      RoleEntity rl = fromDto(dto);
      RoleEntity saved=roleDbBean.create(rl);
      
       return toDto(saved);
    }
    
}
