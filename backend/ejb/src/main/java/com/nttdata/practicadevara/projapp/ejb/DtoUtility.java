package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.db.ApplicationEntity;
import com.nttdata.practicadevara.projapp.db.ApplicationRoleEntity;
import com.nttdata.practicadevara.projapp.db.ApplicationRolesTechnologiesEntity;
import com.nttdata.practicadevara.projapp.db.LevelEntity;
import com.nttdata.practicadevara.projapp.db.RoleEntity;
import com.nttdata.practicadevara.projapp.db.TechnologyEntity;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleTechnologyDto;
import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DtoUtility {

    static List<ApplicationDto> toDtoAppList(List<ApplicationEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    static ApplicationDto toDto(ApplicationEntity e) {
        ApplicationDto dto;
        if (e != null) {
            dto = new ApplicationDto(e.getId(), e.getName(), e.getDescr());
            List<ApplicationRoleEntity> appRoles = e.getAppRoles();
            for (ApplicationRoleEntity appRole : appRoles) {
                ApplicationRoleDto roleDto = new ApplicationRoleDto(appRole.getId(), toDto(appRole.getRole()));
                for (ApplicationRolesTechnologiesEntity arTechEntity : appRole.getTechnologies()) {
                    roleDto.getTechnologies().add(toDto(arTechEntity));
                }
                dto.getRoles().add(roleDto);
            }
        } else {
            dto = new ApplicationDto();
        }
        return dto;
    }

    static RoleDto toDto(RoleEntity e) {
        return new RoleDto(e.getId(), e.getName());
    }

    static ApplicationRoleTechnologyDto toDto(ApplicationRolesTechnologiesEntity e) {
        return new ApplicationRoleTechnologyDto(e.getId(), toDto(e.getTechnology()), toDto(e.getLevelMin()));
    }

    static TechnologyDto toDto(TechnologyEntity t) {
        return new TechnologyDto(t.getId(), t.getName());
    }

    static LevelDto toDto(LevelEntity lvl) {
        if (lvl != null) {
            return new LevelDto(lvl.getId(), lvl.getName());
        }
        return new LevelDto();
    }

    static ApplicationEntity fromDto(ApplicationDto dto) {
        ApplicationEntity e = new ApplicationEntity();
        e.setId(dto.getId());
        e.setName(dto.getName());
        e.setDescr(dto.getDescription());

        List<ApplicationRoleDto> appRolesDto = dto.getRoles();
        if (appRolesDto != null) {
            for (ApplicationRoleDto appRoleDto : appRolesDto) {
                ApplicationRoleEntity appRole = new ApplicationRoleEntity();
                appRole.setId(appRoleDto.getId());
                appRole.setRole(fromDto(appRoleDto.getRole()));
                for (ApplicationRoleTechnologyDto arTechDto : appRoleDto.getTechnologies()) {
                    appRole.getTechnologies().add(fromDto(arTechDto));
                }
                e.getAppRoles().add(appRole);
            }
        }
        return e;
    }

    static RoleEntity fromDto(RoleDto dto) {
        RoleEntity ret = new RoleEntity();
        if (dto != null) {
            ret.setId(dto.getId());
            ret.setName(dto.getName());
        }
        return ret;
    }

    static ApplicationRolesTechnologiesEntity fromDto(ApplicationRoleTechnologyDto dto) {
        ApplicationRolesTechnologiesEntity ret = new ApplicationRolesTechnologiesEntity();
        if (dto != null) {
            ret.setId(dto.getId());
            ret.setTechnology(fromDto(dto.getTechnology()));
            ret.setLevelMin(fromDto(dto.getMinLevel()));
        }
        return ret;
    }

    static TechnologyEntity fromDto(TechnologyDto dto) {
        TechnologyEntity ret = new TechnologyEntity();
        if (dto != null) {
            ret.setId(dto.getId());
            ret.setName(dto.getName());
        }
        return ret;
    }

    static LevelEntity fromDto(LevelDto dto) {
        LevelEntity ret = new LevelEntity();
        if (dto != null) {
            ret.setId(dto.getId());
            ret.setName(dto.getName());
        }
        return ret;
    }

    static List<LevelDto> toDtoLevelList(List<LevelEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    static List<RoleDto> toDtoRoleList(List<RoleEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
    
    static List<TechnologyDto> toDtoTechnologiesList(List<TechnologyEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
}
