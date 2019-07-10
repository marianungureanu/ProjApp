package com.nttdata.practicadevara.projapp.shared.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author liviu.dima
 */
public class ApplicationRoleDto {

    private static final long serialVersionUID = 10002;

    /**
     * The id of ApplicationRole entity
     */
    private int id;

    /**
     * The role for current vacant position
     */
    private ApplicationDto app;

    private RoleDto role;

    public ApplicationRoleDto() {
    }

    public ApplicationRoleDto(int id, ApplicationDto app, RoleDto role) {
        this.id = id;
        this.app = app;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     public ApplicationDto getApp() {
        return app;
    }

    public void setApp(ApplicationDto app) {
        this.app = app;
    }
    
    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

}
