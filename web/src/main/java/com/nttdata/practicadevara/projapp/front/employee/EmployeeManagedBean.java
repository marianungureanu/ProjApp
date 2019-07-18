package com.nttdata.practicadevara.projapp.front.employee;

import com.nttdata.practicadevara.projapp.shared.dto.EmployeeDto;
import com.nttdata.practicadevara.projapp.shared.dto.EmployeeTechnologyDto;
import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("employeeMBean")
public class EmployeeManagedBean implements Serializable {

    private static final long serialVersionUID = 10001;

    @EJB
    private EmployeeRest employeeRest;

    private EmployeeDto selected;
    private EmployeeTechnologyDto selectedTechnology;
    private boolean isCreate;
    private boolean isEdit;

    /**
     * Creates a new instance
     */
    public EmployeeManagedBean() {
    }

    public List<EmployeeDto> getEmployees() {
        return employeeRest.listEmployees();
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
        return "";
    }

    public String startCreate() {
        isEdit = false;
        isCreate = true;
        selected = new EmployeeDto();
        selected.setSkills(new ArrayList<EmployeeTechnologyDto>());
        return "";
    }

    public String startIndex() {
        isEdit = false;
        isCreate = false;
        selected = null;
        return "";
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

    public String edit() {
        employeeRest.update(selected);
        selected = null;
        isEdit = false;
        return "";
    }

    public String create() {
        employeeRest.create(selected);
        selected = null;
        isCreate = false;
        return "";
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
        EmployeeTechnologyDto newTechnology = new EmployeeTechnologyDto(0, null, new TechnologyDto(0, ""), new LevelDto(0, ""));
        selected.getSkills().add(newTechnology);
        return "";
    }
    
    public void delete() {
        employeeRest.delete(selected);
        selected = null;
    }
    
    private EmployeeTechnologyDto selectedSkill;
    public void setSelectedSkill(EmployeeTechnologyDto skill) {
        selectedSkill = skill;
    }
    
    public void deleteSelectedSkill(){
        selected.getSkills().remove(selectedSkill);
    }
    
    public void addSkill(){
        selected.getSkills().add(new EmployeeTechnologyDto(0, null, new TechnologyDto(), new LevelDto()));
    }
    
    public String update() {
        employeeRest.update(selected);
        return "/index.xhtml";
    }
    
    public String cancel() {
        return "/index.xhtml";
    }
    

}
