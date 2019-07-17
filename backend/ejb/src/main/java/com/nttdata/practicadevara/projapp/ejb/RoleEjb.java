package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.db.DbException;
import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;

import com.nttdata.practicadevara.projapp.db.RoleBean;
import com.nttdata.practicadevara.projapp.db.RoleEntity;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.CascadeType;

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
        RoleEntity saved = roleDbBean.create(rl);

        return toDto(saved);
    }

    public RoleDto findById(int id) {
        RoleEntity entity = roleDbBean.findById(id);
        return toDto(entity);
    }

    public RoleDto update(RoleDto dto) throws DbException {
        RoleEntity entity = roleDbBean.findById(dto.getId());
        entity.setName(dto.getName());
        RoleEntity e = roleDbBean.update(entity);
        return toDto(e);
    }
    
    public void delete(int id)throws DbException {
        roleDbBean.delete(id);
    }    
}
