package com.nttdata.practicadevara.projapp.front.subscription;

/**
 *
 * @author stefana.sireanu
 */

import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionDto;

import java.util.Arrays;
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
        
        tempList =  Arrays.asList(
                new SubscriptionDto(1, null,       new EmployeeDto(1, "User A"), role1), 
                new SubscriptionDto(2, "new",      new EmployeeDto(1, "User A"), role1),
                new SubscriptionDto(3, "rejected", new EmployeeDto(2, "User B"), role2),
                new SubscriptionDto(4, "new",      new EmployeeDto(2, "User B"), role3),
                new SubscriptionDto(5, "accepted", new EmployeeDto(3, "User C"), role3),
                new SubscriptionDto(6, "rejected", new EmployeeDto(3, "User C"), role2)
        );
    }

    public List<SubscriptionDto> listSubscriptions() {
        return tempList;
    }

    public SubscriptionDto update(SubscriptionDto entry) {
        return entry;
    }

    public SubscriptionDto create(SubscriptionDto entry) {
        entry.setId(tempIndex++);
        tempList.add(entry);
        return entry;
    }
    
}
