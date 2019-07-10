package com.nttdata.practicadevara.projapp.shared.dto;

/**
 * Class holding subscription for a given employee and a applicationRole
 */
public class SubscriptionDto {
    
    private static final long serialVersionUID = 10008;
    
    /**
     * The id of the given entity
     */
    private int id;
    
    /**
     * Current status: null, new, accepted, rejected
     */
    private String status;
    
    /**
     * Employee that made a subscription
     */
    private EmployeeDto employee;
    
    /**
     * The role/position for which the subscription has been made.
     */
    private ApplicationRoleDto appRole;
    
    public SubscriptionDto(){
    }
    
    public SubscriptionDto(int id, String status, EmployeeDto employee, ApplicationRoleDto roleApp){
        this.id=id;
        this.status=status;
        this.employee = employee;
        this.appRole = roleApp;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status=status;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public ApplicationRoleDto getAppRole() {
        return appRole;
    }

    public void setAppRole(ApplicationRoleDto appRole) {
        this.appRole = appRole;
    }

    
}
