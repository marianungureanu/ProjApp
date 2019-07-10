/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ovidiu.hulea
 */
@Entity
@Table (name = "technology", schema = TechnologyEntity.SCHEMA_NAME)
@NamedQueries({
    @NamedQuery(name = TechnologyEntity.FIND_ALL, query = "SELECT t FROM TechnologyEntity t"),
    @NamedQuery(name = TechnologyEntity.FIND_ONE, query = "SELECT t FROM TechnologyEntity t WHERE t.id = :id")
})
public class TechnologyEntity implements Serializable{
    public static final String SCHEMA_NAME = "projappdb";
    public static final String FIND_ALL = "technology_findAllQuery";
    public static final String FIND_ONE = "technology_findOneQuery";

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    
    

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
    
    @OneToMany
     private List<EmployeetechnologyEntity> employeeTechnologyObject;
   
     private List<ApplicationrolestechnologiesEntity> appRolesTechnology;
    
}
