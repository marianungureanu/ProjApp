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
    private RoleBean roleDbBean;

    @EJB
    private TechnologyBean technologyDbBean;

    @EJB
    private LevelBean levelDbBean;

    public List<ApplicationDto> list() {
        List<ApplicationEntity> entities = applicationDbBean.findAll();
        return toDtoAppList(entities);
    }

    public ApplicationDto create(ApplicationDto dto) throws DbException {
        ApplicationEntity e = new ApplicationEntity();
        copyInto(dto, e);
        ApplicationEntity entity = applicationDbBean.create(e);
        return toDto(entity);
    }

    public ApplicationDto update(ApplicationDto dto) throws DbException {
        ApplicationEntity entity = applicationDbBean.findById(dto.getId());
        copyInto(dto, entity);
        ApplicationEntity e = applicationDbBean.update(entity);
        return toDto(e);
    }

    public void delete(int id) {
        applicationDbBean.delete(id);
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
                    RoleEntity role = roleDbBean.findById(appRoleDto.getRole().getId());
                    appRole.setRole(role);
                    appRole.setApp(e);
                    for (ApplicationRoleTechnologyDto arTechDto : appRoleDto.getTechnologies()) {
                        ApplicationRolesTechnologiesEntity arTechEntity = new ApplicationRolesTechnologiesEntity();
                        arTechEntity.setApplicationRole(appRole);
                        TechnologyEntity techEntity = technologyDbBean.findById(arTechDto.getTechnology().getId());
                        arTechEntity.setTechnology(techEntity);
                        LevelEntity levelEntity = levelDbBean.findById(arTechDto.getMinLevel().getId());
                        arTechEntity.setLevelMin(levelEntity);
                        appRole.getTechnologies().add(arTechEntity);
                    }
                    e.getAppRoles().add(appRole);
                }
            }
        }
    }
}
