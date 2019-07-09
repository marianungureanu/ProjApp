package com.nttdata.practicadevara.projapp.front.employee;

import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeTechnologyDto;
import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
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
                    new EmployeeTechnologyDto(1, new TechnologyDto(i, "Java"+i), new LevelDto(i, "Level "+i)),
                    new EmployeeTechnologyDto(1, new TechnologyDto(i, "MySql"+i), new LevelDto(i, "Level "+i)),
                    new EmployeeTechnologyDto(1, new TechnologyDto(i, "Mockito"+i), new LevelDto(i, "Level "+i))
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
