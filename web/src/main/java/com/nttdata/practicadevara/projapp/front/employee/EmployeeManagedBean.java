package com.nttdata.practicadevara.projapp.front.employee;

import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeTechnologyDto;
import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("employeeMBean")
public class EmployeeManagedBean implements Serializable {

    private static final long serialVersionUID = 10001;

    private static final String EMPLOYEE_XHTML = "/admin/employee/index";
    private static final String CREATE_OR_EDIT_XHTML = "/admin/employee/createOrEditEmployee";

    @EJB
    private EmployeeRest employeeRest;

    private EmployeeDto selected;
    private EmployeeTechnologyDto selectedTechnology;
    private List<EmployeeDto> employeeList;
    private boolean isCreate;
    private boolean isEdit;

    /**
     * Creates a new instance
     */
    public EmployeeManagedBean() {
    }

    public void init() {
        employeeList = employeeRest.listEmployees(); 
    }

    public List<EmployeeDto> getEmployees() {
        if (employeeList == null) {
            init();
        }
        return employeeList;
    }

    public EmployeeDto getSelected() {
        return selected;
    }

    public void setSelected(EmployeeDto selectedEmployee) {
        this.selected = selectedEmployee;
    }

    public String startEdit() {
        isEdit = true;
        isCreate = false;
        return CREATE_OR_EDIT_XHTML;
    }

    public String startCreate() {
        isEdit = false;
        isCreate = true;
        selected = new EmployeeDto();
        return CREATE_OR_EDIT_XHTML;
    }

    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void reload() {
        employeeList = null;
    }

    public String edit() {
        employeeRest.update(selected);
        selected = null;
        reload();
        isEdit = false;
        return EMPLOYEE_XHTML;
    }

    public String create() {
        employeeRest.create(selected);
        selected = null;
        reload();
        isCreate = false;
        return EMPLOYEE_XHTML;
    }

    public String toEmployeeIndex() {
        return EMPLOYEE_XHTML;
    }

    public String deleteTechnologyForSelected() {
        if (null != selected.getSkills() && selectedTechnology != null) {
            selected.getSkills().remove(selectedTechnology);
        }
        return "";
    }

    public void setSelectedTechnology(EmployeeTechnologyDto v) {
        this.selectedTechnology = v;
    }

    public String addTechnologyForSelected() {
        EmployeeTechnologyDto newTechnology = new EmployeeTechnologyDto(0, new EmployeeDto(0,""),new TechnologyDto(0, ""), new LevelDto(0, ""));
        selected.getSkills().add(newTechnology);
        return "";
    }
}
