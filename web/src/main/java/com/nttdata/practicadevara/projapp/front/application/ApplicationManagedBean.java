package com.nttdata.practicadevara.projapp.front.application;

import com.nttdata.practicadevara.projapp.shared.dto.ApplicationDto;
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
@Named("applicationMBean")
public class ApplicationManagedBean implements Serializable {

    private static final long serialVersionUID = 10001;

    private static final String APPLICATIONROLE_XHTML = "/admin/application/index";
    private static final String CREATE_OR_EDIT_XHTML = "/admin/application/createOrEditApplication";
    private boolean isCreate;
    private boolean isEdit;
    private ApplicationDto selected;
    private List<ApplicationDto> applicationList;

    @EJB
    private ApplicationRest restClient;

    public void reload() {
        applicationList = null;
    }

    public ApplicationManagedBean() {

    }

    public void init() {
        applicationList = restClient.listApplications();
    }

    public List<ApplicationDto> getApplications() {
        if (applicationList == null) {
            init();
        }
        return applicationList;
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
        isEdit = false;
        isCreate = true;
        selected = new ApplicationDto();
        return CREATE_OR_EDIT_XHTML;
    }

    public ApplicationDto getSelected() {
        return selected;
    }

    public void setSelected(ApplicationDto selectApplication) {
        this.selected = selectApplication;
        System.out.println("Selected Applciation "+selectApplication.getName());
    }
    
    public String edit() {
        restClient.update(selected);
        selected = null;
        reload();
        isEdit = false;
        return APPLICATIONROLE_XHTML;
    }

    public String create() {
        restClient.create(selected);
        selected = null;
        reload();
        isCreate = false;
        return APPLICATIONROLE_XHTML;
    }


    public String toApplicationRoleIndex() {
        return APPLICATIONROLE_XHTML;
    }
}
