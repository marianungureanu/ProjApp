package com.nttdata.practicadevara.projapp.front.application;

import com.nttdata.practicadevara.projapp.shared.dto.ApplicationDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleTechnologyDto;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.SubscriptionDto;
import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class ApplicationRest {
    private int appIdx = 1;           //to be delete when REST services are ready
    private int appRoleIdx = 1;
    private List<ApplicationDto> tempList;  //to be delete when REST services are ready
    List<ApplicationDto> listApplicationRole;
    List<TechnologyDto> technologies;
    List<LevelDto> levels;
    
    @PostConstruct
    public void init() {
        technologies = Arrays.asList(new TechnologyDto(1, "JavaEE"), new TechnologyDto(2, "MySql"), new TechnologyDto(3, "JUnit"));
        levels = Arrays.asList(new LevelDto(1, "junior"), new LevelDto(2, "middle"), new LevelDto(3, "senior"));
        tempList = new ArrayList<>();
        ApplicationDto app = new ApplicationDto(appIdx++,"Engineering Application", "This application does that and that and also that. It is used to leverage engineering calculations.");
        ApplicationRoleDto ar = new ApplicationRoleDto(appRoleIdx++, new RoleDto(1, "Junior Dev") );
        ar.getTechnologies().add(new ApplicationRoleTechnologyDto(1,technologies.get(1), levels.get(0)));
        app.getRoles().add(ar);
        tempList.add(app);
        
        app = new ApplicationDto(appIdx++,"Banking", "This application allows banking users to do their online banking actions.");
        ar = new ApplicationRoleDto(appRoleIdx++, new RoleDto(2, "Senior Dev") );
        ar.getTechnologies().add(new ApplicationRoleTechnologyDto(2,technologies.get(0), levels.get(2)));
        app.getRoles().add(ar);
        ar = new ApplicationRoleDto(appRoleIdx++, new RoleDto(3, "Middle Dev") );
        ar.getTechnologies().add(new ApplicationRoleTechnologyDto(3,technologies.get(1), levels.get(1)));
        ar.getTechnologies().add(new ApplicationRoleTechnologyDto(4,technologies.get(2), levels.get(0)));
        ar.getTechnologies().add(new ApplicationRoleTechnologyDto(5,technologies.get(0), levels.get(2)));
        app.getRoles().add(ar);
        tempList.add(app);
        
        app = new ApplicationDto(appIdx++,"Scientific Research", "This application help researchers to publish their findings and that and that.");
        ar = new ApplicationRoleDto(appRoleIdx++, new RoleDto(4, "Senior Dev") );
        ar.getTechnologies().add(new ApplicationRoleTechnologyDto(6,technologies.get(1), levels.get(2)));
        ar.getTechnologies().add(new ApplicationRoleTechnologyDto(7,technologies.get(2), levels.get(2)));
        app.getRoles().add(ar);
        ar = new ApplicationRoleDto(appRoleIdx++, new RoleDto(5, "Junior Dev") );
        ar.getTechnologies().add(new ApplicationRoleTechnologyDto(5, technologies.get(0), levels.get(0)));
        app.getRoles().add(ar);
        tempList.add(app);
    }
    
    public List<SubscriptionDto> getSubscriptions(ApplicationRoleDto role) {
        EmployeeDto userA = new EmployeeDto(1, "User A");
        EmployeeDto userB = new EmployeeDto(1, "User B");
        return Arrays.asList(new SubscriptionDto(1, null, userA, role), new SubscriptionDto(2, "new", userB, role));
    }
            
    public List<ApplicationDto> listApplications() {
        return tempList;
    }
    
    public ApplicationDto update(ApplicationDto entry) {
        return entry;
    }

    public ApplicationDto create(ApplicationDto entry) {
        entry.setId(appIdx++);
        tempList.add(entry);
        return entry;
    }
}
