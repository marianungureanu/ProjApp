package com.nttdata.practicadevara.projapp.shared.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ovidiu.hulea
 */
public class ApplicationDto implements Serializable{
    private static final long serialVersionUID = 10001;
    
    /**
     * The id in database for the Application
     */
    private int id;
    
    /**
     * The application name
     */
    private String name;
    
    /**
     * The application's description
     */
    private String description;
    
    /**
     * The list of available positions (roles)
     */
    private List<ApplicationRoleDto> roles;

    public ApplicationDto() {
    }

    public ApplicationDto(int id, String name, String descr) {
        this.id = id;
        this.name = name;
        this.description = descr;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ApplicationRoleDto> getRoles() {
        if(roles == null) {
            roles = new ArrayList<ApplicationRoleDto>();
        }
        return roles;
    }

    public void setRoles(List<ApplicationRoleDto> roles) {
        this.roles = roles;
    }
}
