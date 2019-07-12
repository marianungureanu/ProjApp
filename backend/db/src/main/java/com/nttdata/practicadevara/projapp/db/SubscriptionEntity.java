/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author eduard.ioo
 */
@Entity
@Table(name = "subscription", schema = SubscriptionEntity.SCHEMA_NAME)
@NamedQueries({
    @NamedQuery(name = SubscriptionEntity.FIND_ALL, query = "SELECT s FROM SubscriptionEntity s where s.idapprole.id = :id"),
    @NamedQuery(name = SubscriptionEntity.FIND_ALL_BY_EMPLOYEE, query = "SELECT s FROM SubscriptionEntity s where s.idapprole.id = :idapprole and s.idemployee.id = :idemp")
})
public class SubscriptionEntity implements Serializable {

    public static final String SCHEMA_NAME = "projappdb";
    public static final String FIND_ALL = "subscription_findAllQuery";
    public static final String FIND_ALL_BY_EMPLOYEE = "subscription_findAllQuery_by_employee";

    //id, status, id Employee, id Application Role
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status")
    private String name;

   @JoinColumn(name = "idemployee", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeEntity idemployee;
   
    @JoinColumn(name = "idapprole", referencedColumnName = "id")
    @ManyToOne(optional = false)
     private ApplicationRoleEntity idapprole;
    
     public SubscriptionEntity() {
    }

    public SubscriptionEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

     public EmployeeEntity getIdemployee() {
        return idemployee;
    }
    
     public void setIdemplpoyee(EmployeeEntity idemployee) {
        this.idemployee = idemployee;
    }
     
     
    public ApplicationRoleEntity getIdapprole() {
        return idapprole;
    }

    public void setIdapprole(ApplicationRoleEntity idapprole) {
        this.idapprole = idapprole;
    }
    
     @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubscriptionEntity)) {
            return false;
        }
        SubscriptionEntity other = (SubscriptionEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttdata.practicadevara.projapp.db.SubcriptionEntity[ id=" + id + " ]";
    }
    
}
