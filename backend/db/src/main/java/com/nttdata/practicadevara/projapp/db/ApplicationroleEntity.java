/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.db;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebastian.stoica
 */
@Entity
@Table(name = "applicationrole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = ApplicationroleEntity.FIND_ALL, query = "SELECT a FROM ApplicationroleEntity a")
    , @NamedQuery(name = ApplicationroleEntity.FIND_BY_ID, query = "SELECT a FROM ApplicationroleEntity a WHERE a.id = :id")})
public class ApplicationroleEntity implements Serializable {

    public static final String SCHEMA_NAME = "projappdb";
    public static final String FIND_ALL = "application_role_findAllQuery";
    public static final String FIND_BY_ID = "application_role_findById";
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "idapp", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ApplicationEntity idapp;

    @JoinColumn(name = "idrole", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RoleEntity idrole;

    public ApplicationroleEntity() {
    }

    public ApplicationroleEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApplicationEntity getIdapp() {
        return idapp;
    }

    public void setIdapp(ApplicationEntity idapp) {
        this.idapp = idapp;
    }

    public RoleEntity getIdrole() {
        return idrole;
    }

    public void setIdrole(RoleEntity idrole) {
        this.idrole = idrole;
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
        if (!(object instanceof ApplicationroleEntity)) {
            return false;
        }
        ApplicationroleEntity other = (ApplicationroleEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nttdata.practicadevara.projapp.db.ApplicationroleEntity[ id=" + id + " ]";
    }
    @OneToMany
    private List<SubscriptionEntity> subscription;
    private List<ApplicationrolestechnologiesEntity> appRolesTechnology;
}
