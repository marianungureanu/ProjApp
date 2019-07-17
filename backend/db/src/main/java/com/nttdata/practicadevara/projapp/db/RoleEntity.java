/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ovidiu.hulea
 */
@Entity
@Table(name = "role", schema = RoleEntity.SCHEMA_NAME)
@NamedQueries({
    @NamedQuery(name = RoleEntity.FIND_ALL, query = "SELECT l FROM RoleEntity l")
    ,
    @NamedQuery(name = RoleEntity.FIND_BY_ID, query = "SELECT e FROM RoleEntity e where e.id = :id")
})
public class RoleEntity implements Serializable {

    public static final String SCHEMA_NAME = "projappdb";
    public static final String FIND_ALL = "role_findAllQuery";
    public static final String FIND_BY_ID = "role_findByIdQuery";

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role", cascade = {PERSIST, MERGE, REFRESH, REMOVE})
    private List<ApplicationRoleEntity> appRoles = new ArrayList<ApplicationRoleEntity>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ApplicationRoleEntity> getAppRoles() {
        if (appRoles == null) {
            appRoles = new ArrayList<ApplicationRoleEntity>();
        }
        return appRoles;
    }

    public void setAppRoles(List<ApplicationRoleEntity> appRoles) {
        this.appRoles = appRoles;
    }

}
