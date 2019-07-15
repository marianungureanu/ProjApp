package com.nttdata.practicadevara.projapp.shared.dto;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRoleDto {
    private static final long serialVersionUID = 10002;
    
    /**
     * The id of ApplicationRole entity 
     */
    private int id;
    
    /**
     * The role for current vacant position
     */
    private RoleDto role;
    
    /**
     * The technologies needed for current position/role
     */
    private List<ApplicationRoleTechnologyDto> technologies;
    
    public ApplicationRoleDto(){
    }
    
    public ApplicationRoleDto(int id, RoleDto role){
        this.id=id;
        this.role = role;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public List<ApplicationRoleTechnologyDto> getTechnologies() {
        if(technologies == null) {
            technologies = new ArrayList<ApplicationRoleTechnologyDto>();
        }
        return technologies;
    }

    public void setTechnologies(List<ApplicationRoleTechnologyDto> technologies) {
        this.technologies = technologies;
    }
}
