package com.nttdata.practicadevara.projapp.front.role;

import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import java.io.Serializable;
import java.util.ArrayList;
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
    private boolean isCreate;
    private boolean isEdit;

    /**
     * Creates a new instance
     */
    public RoleManagedBean() {
    }

    public List<RoleDto> getRolesWithFirstEmpty() {
        List<RoleDto> ret = new ArrayList<>();
        ret.add(new RoleDto(0, ""));
        ret.addAll(roleRest.listRoles());
        return ret;
    }

    public List<RoleDto> getRoles() {
       return roleRest.listRoles();
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

    public String edit() {
        roleRest.update(selected);
        selected = null;
        isEdit = false;
        return ROLE_XHTML;
    }

    public String create() {
        roleRest.create(selected);
        selected = null;
        isCreate = false;
        return ROLE_XHTML;
    }

    public String toRoleIndex() {
        return ROLE_XHTML;
    }
}
