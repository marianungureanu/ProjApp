package com.nttdata.practicadevara.projapp.ejb;

import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;

import com.nttdata.practicadevara.projapp.db.ApplicationBean;
import com.nttdata.practicadevara.projapp.db.ApplicationEntity;
import com.nttdata.practicadevara.projapp.db.ApplicationRoleEntity;
import com.nttdata.practicadevara.projapp.db.ApplicationRolesTechnologiesEntity;
import com.nttdata.practicadevara.projapp.db.DbException;
import com.nttdata.practicadevara.projapp.db.LevelBean;
import com.nttdata.practicadevara.projapp.db.LevelEntity;
import com.nttdata.practicadevara.projapp.db.RoleBean;
import com.nttdata.practicadevara.projapp.db.RoleEntity;
import com.nttdata.practicadevara.projapp.db.TechnologyBean;
import com.nttdata.practicadevara.projapp.db.TechnologyEntity;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleTechnologyDto;
import java.util.List;
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

    @EJB
    private TechnologyBean technologyBean;

    @EJB
    private LevelBean levelBean;

    @EJB
    private RoleBean roleBean;

    public List<ApplicationDto> list() {
        List<ApplicationEntity> entities = applicationDbBean.findAll();
        return toDtoAppList(entities);
    }

    public ApplicationDto findById(int id) throws DbException  {
        ApplicationEntity entity = applicationDbBean.findById(id);
        return DtoUtility.toDto(entity);
    }

    public ApplicationDto create(ApplicationDto dto) {
        ApplicationEntity e = fromDto(dto);
        applicationDbBean.create(e);
        return DtoUtility.toDto(e);
    }

    public void delete(int id) {
        applicationDbBean.delete(id);
    }

    public ApplicationDto update(ApplicationDto dto) {
        ApplicationEntity e = fromDto(dto);
        ApplicationEntity entity = applicationDbBean.update(e);
        return toDto(entity);
    }

    private void copyInto(ApplicationDto dto, ApplicationEntity e) throws DbException {
        e.setName(dto.getName());
        e.setDescr(dto.getDescription());
        e.getAppRoles().clear();
        List<ApplicationRoleDto> appRolesDto = dto.getRoles();
        if (appRolesDto != null) {
            for (ApplicationRoleDto appRoleDto : appRolesDto) {
                ApplicationRoleEntity appRole = new ApplicationRoleEntity();
                if (appRoleDto.getRole() == null) {
                    throw new DbException("ERROR: there is ApplicationRoleDto.role = NULL");
                } else {
                    RoleEntity role = roleBean.findById(appRoleDto.getRole().getId());
                    appRole.setRole(role);
                    for (ApplicationRoleTechnologyDto arTechDto : appRoleDto.getTechnologies()) {
                        ApplicationRolesTechnologiesEntity arTechEntity = new ApplicationRolesTechnologiesEntity();
                        arTechEntity.setApplicationRole(appRole);
                        TechnologyEntity techEntity = technologyBean.findById(arTechDto.getTechnology().getId());
                        arTechEntity.setTechnology(techEntity);
                        LevelEntity levelEntity = levelBean.findById(arTechDto.getMinLevel().getId());
                        arTechEntity.setLevelMin(levelEntity);
                        appRole.getTechnologies().add(fromDto(arTechDto));
                    }
                    e.getAppRoles().add(appRole);
                }
            }
        }
    }
}
