package com.nttdata.practicadevara.projapp.front.application;

import com.nttdata.practicadevara.projapp.shared.dto.ApplicationDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationRoleTechnologyDto;
import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@SessionScoped
@Named("applicationMBean")
public class ApplicationManagedBean implements Serializable {

    private static final long serialVersionUID = 10001;

    private boolean isCreate;
    private boolean isEdit;
    private ApplicationDto selected;
    private ApplicationRoleDto selectedApplicationRole;
    private ApplicationRoleTechnologyDto selectedApplicationRoleTechnology;

    @EJB
    private ApplicationRest restClient;

    public ApplicationManagedBean() {

    }

    public List<ApplicationDto> getApplications() {
        return restClient.listApplications();
    }

    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public boolean isIsIndex() {
        return !isCreate && !isEdit;
    }

    public String startEdit() {
        isEdit = true;
        isCreate = false;
        return "";
    }

    public String startCreate() {
        isEdit = false;
        isCreate = true;
        selected = new ApplicationDto();
        return "";
    }

    public String startIndex() {
        isEdit = false;
        isCreate = false;
        return "";
    }

    public ApplicationDto getSelected() {
        return selected;
    }

    public void setSelected(ApplicationDto selectApplication) {
        this.selected = selectApplication;
    }

    public String edit() {
        try {
            restClient.update(selected);
            selected = null;
            isEdit = false;
        } catch (Exception e) {
            Throwable t = e;
            while (t.getCause() != null && t != t.getCause()) {
                t = t.getCause();
            }
            FacesContext.getCurrentInstance().addMessage("createApplication", new FacesMessage("Error", "Cannot update application: " + t.getMessage()));
        }
        return "";
    }

    public String create() {
        try {
            restClient.create(selected);
            selected = null;
            isCreate = false;
        } catch (Exception e) {
            Throwable t = e;
            while (t.getCause() != null && t != t.getCause()) {
                t = t.getCause();
            }
            FacesContext.getCurrentInstance().addMessage("createApplication", new FacesMessage("Error", "Cannot create application: " + t.getMessage()));
        }

        return "";
    }

    public String delete() {
        try {
            restClient.delete(selected);
        } catch (Exception e) {
            Throwable t = e;
            while (t.getCause() != null && t != t.getCause()) {
                t = t.getCause();
            }

            FacesContext.getCurrentInstance().addMessage("delete application", new FacesMessage("Error", "Cannot delete application: " + t.getMessage()));
        }
        selected = null;
        return "";
    }

    public void newRole() {
        ApplicationRoleDto newRole = new ApplicationRoleDto();
        newRole.setRole(new RoleDto());
        ApplicationRoleTechnologyDto appRoleTech = new ApplicationRoleTechnologyDto();
        appRoleTech.setMinLevel(new LevelDto());
        appRoleTech.setTechnology(new TechnologyDto());
        newRole.getTechnologies().add(appRoleTech);
        selected.getRoles().add(newRole);
    }

    public void deleteRole() {
        selected.getRoles().remove(selectedApplicationRole);
    }

    public void setSelectedApplicationRole(ApplicationRoleDto s) {
        this.selectedApplicationRole = s;
    }

    public void setSelectedApplicationRoleTechnology(ApplicationRoleTechnologyDto s) {
        this.selectedApplicationRoleTechnology = s;
    }

    public void addApplicationRoleTechnology() {
        ApplicationRoleTechnologyDto skill = new ApplicationRoleTechnologyDto(0, new TechnologyDto(), new LevelDto());
        this.selectedApplicationRole.getTechnologies().add(skill);
    }

    public void deleteSelectedApplicationRoleTechnology() {
        this.selectedApplicationRole.getTechnologies().remove(this.selectedApplicationRoleTechnology);
    }
}
