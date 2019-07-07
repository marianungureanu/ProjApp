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
 * @author sebastian.stoica
 */
@Entity
@Table(name = "applicationrolestechnologies", schema = ApplicationrolestechnologiesEntity.SCHEMA_NAME)
@NamedQueries({
    @NamedQuery(name = ApplicationrolestechnologiesEntity.FIND_ALL, query = "SELECT ar FROM ApplicationrolestechnologiesEntity ar")
})
class ApplicationrolestechnologiesEntity implements Serializable {

    public static final String SCHEMA_NAME = "projappdb";
    public static final String FIND_ALL = "application_roles_technologies_findAllQuery";

    //id, status, id Employee, id Application Role
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "idApplicationRole", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ApplicationroleEntity idApplicationRole;

    @JoinColumn(name = "idTechnology", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TechnologyEntity idTechnology;

    @JoinColumn(name = "idLevelMin", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LevelEntity idLevelMin;

    public ApplicationrolestechnologiesEntity() {
    }

    public ApplicationrolestechnologiesEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApplicationroleEntity getIdApplicationRole() {
        return idApplicationRole;
    }

    public void setApplicationRole(ApplicationroleEntity idApplicationRole) {
        this.idApplicationRole = idApplicationRole;
    }

    public TechnologyEntity getIdtechnology() {
        return idTechnology;
    }

    public void setIdtechnology(TechnologyEntity idTechnology) {
        this.idTechnology = idTechnology;
    }

    public LevelEntity getidLevelMin() {
        return idLevelMin;
    }

    public void setIdlevelMin(LevelEntity idLevelMin) {
        this.idLevelMin = idLevelMin;
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
        if (!(object instanceof ApplicationrolestechnologiesEntity)) {
            return false;
        }
        ApplicationrolestechnologiesEntity other = (ApplicationrolestechnologiesEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttdata.practicadevara.projapp.db.ApplicationrolestechnologiesEntity[ id=" + id + " ]";
    }
}
