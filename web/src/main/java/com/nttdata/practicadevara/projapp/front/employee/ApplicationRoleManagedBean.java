/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.front.employee;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.ejb.EJB;
import javax.inject.Named;

/**
 *
 * @author liviu.dima
 */

@SessionScoped
@Named("ApplicationRoleMBean")
public class ApplicationRoleManagedBean implements Serializable {

    private static final long serialVersionUID = 10001;

    private static final String APPLICATIONROLE_XHTML = "/admin/applicationrole/index";
    private static final String CREATE_OR_EDIT_XHTML = "/admin/applicationrole/createOrEditApplicationRole";
    private boolean isCreate;
    private boolean isEdit;
    private ApplicationRoleDto selected;
    
    @EJB
    private ApplicationRoleRest applicationrolerest;
    private List<ApplicationRoleDto> applicationroleList;

    
     public void reload() {
        applicationroleList = null;
    }

    public ApplicationRoleManagedBean() {

    }
    public void init() {
        applicationroleList = applicationrolerest.listApplicationRole();

    }

    public List<ApplicationRoleDto> getApplicationRoles() {
        if (applicationroleList == null) {
            init();
        }
        return applicationroleList;
    }    
    
    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsEdit() {
        return isEdit;
    }
    
     public String startEdit() {
        isEdit = true;
        isCreate = false;
        return CREATE_OR_EDIT_XHTML;
    }
     
      public String startCreate() {
        isEdit = true;
        isCreate = false;
        return CREATE_OR_EDIT_XHTML;
    }
     
     public ApplicationRoleDto getSelected() {
        return selected;
    }
     
    public String edit() {
        applicationrolerest.update(selected);
        selected = null;
        reload();
        isEdit = false;
        return APPLICATIONROLE_XHTML;
    }

    public String create() {
        applicationrolerest.create(selected);
        selected = null;
        reload();
        isCreate = false;
        return APPLICATIONROLE_XHTML;
    } 
     
    public void setSelected(ApplicationRoleDto selectApplication) {
        this.selected = selectApplication;
    }
    
    public String toApplicationRoleIndex() {
        return APPLICATIONROLE_XHTML;
    }
}
