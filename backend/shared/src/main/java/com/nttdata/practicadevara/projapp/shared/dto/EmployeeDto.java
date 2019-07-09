package com.nttdata.practicadevara.projapp.shared.dto;

import java.io.Serializable;
import java.util.List;

public class EmployeeDto implements Serializable {
    private static final long serialVersionUID = 10004;
    
    private int id;
    private String name;
      private List<EmployeeTechnologyDto> skills;
    
    public EmployeeDto() {
    }

    public EmployeeDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeTechnologyDto> getSkills() {
        return skills;
    }

    public void setSkills(List<EmployeeTechnologyDto> skills) {
        this.skills = skills;
    }
}
