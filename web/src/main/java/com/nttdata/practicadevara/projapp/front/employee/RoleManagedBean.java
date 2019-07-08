/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.nttdata.practicadevara.projapp.front.employee.RoleRest;
import com.nttdata.practicadevara.projapp.shared.dto.RoleDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author liviu.dima
 */

@SessionScoped
@Named("RoleManagedBean")
public class RoleManagedBean implements Serializable {
    private static final long serialVersionUID=10001;
    private static final String APPLICATIONROLE_XHTML = "/admin/applicationrole/index";
    private static final String CREATE_OR_EDIT_XHTML = "/admin/applicationrole/createOrEditAplicationRole";

    @EJB
    private RoleRest rolerest;
    private List<RoleDto> rolelist;

    public RoleManagedBean() {

    }
    public void init() {
        rolelist = rolerest.listRole();

    }

    public List<RoleDto> getRoles() {
        if (rolelist == null) {
            init();
        }
        return rolelist;
    }
}
