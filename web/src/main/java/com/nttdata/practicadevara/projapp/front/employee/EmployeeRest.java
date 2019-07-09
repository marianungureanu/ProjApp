package com.nttdata.practicadevara.projapp.front.employee;

import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeTechnologyDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EmployeeRest {

    private int tempIndex = 0;           //to be delete when REST services are ready
    private List<EmployeeDto> tempList;  //to be delete when REST services are ready

    @PostConstruct
    public void init() {
        tempList = new ArrayList<>();
        for(int i=0; i<5; i++) { 
            EmployeeDto e = new EmployeeDto(tempIndex++, "Employee " + tempIndex);
            List<EmployeeTechnologyDto> techs = Arrays.asList(
                    new EmployeeTechnologyDto(1, "Oracle"+i, "Level 1"),
                    new EmployeeTechnologyDto(1, "Java"+i, "Level 2"),
                    new EmployeeTechnologyDto(1, ".Net"+i, "Level 3")
            );
            tempList.add(e);
        }
    }

    public List<EmployeeDto> listEmployees() {
        return tempList;
    }

    public EmployeeDto update(EmployeeDto entry) {
        return entry;
    }

    public EmployeeDto create(EmployeeDto entry) {
        entry.setId(tempIndex++);
        tempList.add(entry);
        return entry;
    }
}
