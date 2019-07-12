/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastian.stoica
 */
@Entity
@Table(name = "employeetechnology")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = EmployeetechnologyEntity.FIND_REQUEST , query = "SELECT emp FROM EmployeetechnologyEntity emp"),
     })
public class EmployeetechnologyEntity implements Serializable {

    public static final String SCHEMA_NAME = "projappdb";
    public static final String FIND_REQUEST = "employee_technology_findRequestQuery";
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "idemployee", referencedColumnName = "id")
    @OneToOne(optional = false)
    private EmployeeEntity employee;

    @JoinColumn(name = "idlevel", referencedColumnName = "id")
    @OneToOne(optional = false)
    private LevelEntity level;

    @JoinColumn(name = "idtechnology", referencedColumnName = "id")
    @OneToOne(optional = false)
    private TechnologyEntity technology;

    public EmployeetechnologyEntity() {
    }

    public EmployeetechnologyEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public LevelEntity getLevel() {
        return level;
    }

    public void setLevel(LevelEntity level) {
        this.level = level;
    }

    public TechnologyEntity getTechnology() {
        return technology;
    }

    public void setTechnology(TechnologyEntity technology) {
        this.technology = technology;
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
        if (!(object instanceof EmployeetechnologyEntity)) {
            return false;
        }
        EmployeetechnologyEntity other = (EmployeetechnologyEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttdata.practicadevara.projapp.db.EmployeetechnologyEntity[ id=" + id + " ]";
    }
}
