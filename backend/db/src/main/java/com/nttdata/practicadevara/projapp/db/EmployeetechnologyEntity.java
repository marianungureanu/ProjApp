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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "EmployeetechnologyEntity.findAll", query = "SELECT e FROM EmployeetechnologyEntity e")
    , @NamedQuery(name = "EmployeetechnologyEntity.findById", query = "SELECT e FROM EmployeetechnologyEntity e WHERE e.id = :id")})
public class EmployeetechnologyEntity implements Serializable {
    
    public static final String SCHEMA_NAME = "projappdb";
    public static final String FIND_ALL = "findAllQuery";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "idemployee", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeEntity idemployee;
    @JoinColumn(name = "idlevel", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LevelEntity idlevel;
    @JoinColumn(name = "idtechnology", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TechnologyEntity idtechnology;

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

    public EmployeeEntity getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(EmployeeEntity idemployee) {
        this.idemployee = idemployee;
    }

    public LevelEntity getIdlevel() {
        return idlevel;
    }

    public void setIdlevel(LevelEntity idlevel) {
        this.idlevel = idlevel;
    }

    public TechnologyEntity getIdtechnology() {
        return idtechnology;
    }

    public void setIdtechnology(TechnologyEntity idtechnology) {
        this.idtechnology = idtechnology;
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
