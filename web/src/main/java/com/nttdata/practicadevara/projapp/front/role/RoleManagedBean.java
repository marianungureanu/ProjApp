package com.nttdata.practicadevara.projapp.front.role;

import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("roleMBean")
public class RoleManagedBean implements Serializable {

    private static final long serialVersionUID = 10001;

    private static final String ROLE_XHTML = "/admin/role/index";
    private static final String CREATE_OR_EDIT_XHTML = "/admin/role/createOrEditRole";

    @EJB
    private RoleRest roleRest;

    private RoleDto selected;
    private List<RoleDto> roleList;
    private boolean isCreate;
    private boolean isEdit;

    /**
     * Creates a new instance
     */
    public RoleManagedBean() {
    }

    public void init() {
        roleList = roleRest.listRoles();
    }

    public List<RoleDto> getRoles() {
        if (roleList == null) {
            init();
        }
        return roleList;
    }

    public RoleDto getSelected() {
        return selected;
    }

    public void setSelected(RoleDto selectedRole) {
        this.selected = selectedRole;
    }

    public String startEdit() {
        isEdit = true;
        isCreate = false;
        return CREATE_OR_EDIT_XHTML;
    }

    public String startCreate() {
        isEdit = false;
        isCreate = true;
        selected = new RoleDto();
        return CREATE_OR_EDIT_XHTML;
    }

    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void reload() {
        roleList = null;
    }

    public String edit() {
        roleRest.update(selected);
        selected = null;
        reload();
        isEdit = false;
        return ROLE_XHTML;
    }

    public String create() {
        roleRest.create(selected);
        selected = null;
        reload();
        isCreate = false;
        return ROLE_XHTML;
    }

    public String toRoleIndex() {
        return ROLE_XHTML;
    }
}
