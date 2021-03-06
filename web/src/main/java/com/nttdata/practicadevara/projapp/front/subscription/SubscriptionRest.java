package com.nttdata.practicadevara.projapp.front.subscription;

/**
 *
 * @author stefana.sireanu
 */

import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionDto;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionStatusEnumDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class SubscriptionRest {
    
    private int tempIndex = 0;           //to be delete when REST services are ready
    private List<SubscriptionDto> tempList;  //to be delete when REST services are ready

    @PostConstruct
    public void init() {
        int appRoleIdx = 1;
        ApplicationRoleDto role1 = new ApplicationRoleDto(appRoleIdx++, new RoleDto(1, "Junior Dev") );
        ApplicationRoleDto role2 = new ApplicationRoleDto(appRoleIdx++, new RoleDto(2, "Middle Dev") );
        ApplicationRoleDto role3 = new ApplicationRoleDto(appRoleIdx++, new RoleDto(3, "Senior Dev") );
        
        tempList =  new ArrayList<>();
        tempList.add(new SubscriptionDto(1, SubscriptionStatusEnumDto.NULL,     new EmployeeDto(1, "User A"), role1));
        tempList.add(new SubscriptionDto(2, SubscriptionStatusEnumDto.NEW,      new EmployeeDto(1, "User A"), role1));
        tempList.add(new SubscriptionDto(3, SubscriptionStatusEnumDto.REJECTED, new EmployeeDto(2, "User B"), role2));
        tempList.add(new SubscriptionDto(4, SubscriptionStatusEnumDto.NEW,      new EmployeeDto(2, "User B"), role3));
        tempList.add(new SubscriptionDto(5, SubscriptionStatusEnumDto.ACCEPTED, new EmployeeDto(3, "User C"), role3));
        tempList.add(new SubscriptionDto(6, SubscriptionStatusEnumDto.REJECTED, new EmployeeDto(3, "User C"), role2));
    }

    public List<SubscriptionDto> listSubscriptions() {
        return tempList;
    }

    public SubscriptionDto update(SubscriptionDto entry) {
        return entry;
    }

    public void delete(SubscriptionDto entry) {
        tempList.remove(entry);
    }

    public SubscriptionDto create(SubscriptionDto entry) {
        entry.setId(tempIndex++);
        tempList.add(entry);
        return entry;
    }
    
}
