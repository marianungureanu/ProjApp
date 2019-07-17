package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.db.ApplicationEntity;
import com.nttdata.practicadevara.projapp.db.ApplicationRoleEntity;
import com.nttdata.practicadevara.projapp.db.ApplicationRolesTechnologiesEntity;
import com.nttdata.practicadevara.projapp.db.EmployeeEntity;
import com.nttdata.practicadevara.projapp.db.EmployeetechnologyEntity;
import com.nttdata.practicadevara.projapp.db.EmployeeEntity;
//import com.nttdata.practicadevara.projapp.db.EmployeetechnologyEntity;
import com.nttdata.practicadevara.projapp.db.LevelEntity;
import com.nttdata.practicadevara.projapp.db.RoleEntity;
import com.nttdata.practicadevara.projapp.db.SubscriptionEntity;
import com.nttdata.practicadevara.projapp.db.TechnologyEntity;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationDto;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeTechnologyDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleTechnologyDto;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionDto;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionStatusEnumDto;
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
                dto.getRoles().add(toDto(appRole));
            }
        } else {
            dto = new ApplicationDto();
        }
        return dto;
    }

    static RoleDto toDto(RoleEntity e) {
        return new RoleDto(e.getId(), e.getName());
    }

    static EmployeeDto toDto(EmployeeEntity e) {
        return new EmployeeDto(e.getId(), e.getName());
    }

    static ApplicationRoleTechnologyDto toDto(ApplicationRolesTechnologiesEntity e) {
        return new ApplicationRoleTechnologyDto(e.getId(), toDto(e.getTechnology()), toDto(e.getLevelMin()));
    }

    static EmployeeTechnologyDto toDto(EmployeetechnologyEntity e) {
        return new EmployeeTechnologyDto(e.getId(), toDto(e.getEmployee()), toDto(e.getTechnology()), toDto(e.getLevel()));
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

    static SubscriptionDto toDto(SubscriptionEntity e) {
        SubscriptionDto dto = null;
        if (e != null) {
            SubscriptionStatusEnumDto status = SubscriptionStatusEnumDto.from(e.getStatus());
            EmployeeDto emp = toDto(e.getIdemployee());
            ApplicationRoleDto ar = toDto(e.getIdapprole());
            dto = new SubscriptionDto(e.getId(), status, emp, ar);
        }
        return dto;
    }

    static ApplicationRoleDto toDto(ApplicationRoleEntity appRole) {
        ApplicationRoleDto roleDto = new ApplicationRoleDto(appRole.getId(), toDto(appRole.getRole()));
        if (appRole.getTechnologies() != null) {
            for (ApplicationRolesTechnologiesEntity arTechEntity : appRole.getTechnologies()) {
                roleDto.getTechnologies().add(toDto(arTechEntity));
            }
        }
        return roleDto;
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

    static EmployeetechnologyEntity fromDto(EmployeeTechnologyDto dto) {
        EmployeetechnologyEntity ret = new EmployeetechnologyEntity();
        if (dto != null) {
            ret.setId(dto.getId());
            ret.setTechnology(fromDto(dto.getTechnology()));
            ret.setLevel(fromDto(dto.getLevel()));
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

    static EmployeeEntity fromDto(EmployeeDto dto) {
        EmployeeEntity ret = new EmployeeEntity();
        if (dto != null) {
            ret.setId(dto.getId());
            ret.setName(dto.getName());
        }
        return ret;
    }
    
    static ApplicationRoleEntity fromDto(ApplicationRoleDto dto) {
       ApplicationRoleEntity ret = new ApplicationRoleEntity();
        if (dto != null) {
            ret.setId(dto.getId());
            ret.setRole(DtoUtility.fromDto(dto.getRole()));
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

    static List<SubscriptionDto> toDtoSubscriptionList(List<SubscriptionEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    static List<ApplicationRoleTechnologyDto> toDtoApplicationRolesTechnologiesList(List<ApplicationRolesTechnologiesEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    static List<EmployeeTechnologyDto> toDtoEmployeeTechnologyList(List<EmployeetechnologyEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    static List<EmployeetechnologyEntity> fromDtoEmployeeTechnologyList(List<EmployeeTechnologyDto> list) {
        if (list != null) {
            return list.stream().map(e -> fromDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }

    static List<EmployeeDto> toDtoEmployeeList(List<EmployeeEntity> list) {
        if (list != null) {
            return list.stream().map(e -> toDto(e)).collect(Collectors.toList());
        }
        return Collections.EMPTY_LIST;
    }
}
