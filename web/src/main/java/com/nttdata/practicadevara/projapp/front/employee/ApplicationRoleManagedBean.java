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
    private static final String CREATE_OR_EDIT_XHTML = "/admin/applicationrole/createOrEditAplicationRole";

    @EJB
    private ApplicationRoleRest applicationrolerest;
    private List<ApplicationRoleDto> applicationroleList;

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
}
