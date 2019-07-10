package com.nttdata.practicadevara.projapp.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;
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
@Table(name = "Application", schema = EmployeeEntity.SCHEMA_NAME)
@NamedQueries({
    @NamedQuery(name = ApplicationEntity.FIND_ALL, query = "SELECT e FROM ApplicationEntity e"),
    @NamedQuery(name = ApplicationEntity.FIND_BY_ID, query = "SELECT e FROM ApplicationEntity e WHERE e.id = :" + ApplicationEntity.ID_PARAM)
})
public class ApplicationEntity implements Serializable {

    private static final long serialVersionUID = 117223295272084434L;
    
    public static final String SCHEMA_NAME = "projappdb";
    public static final String FIND_ALL = "application_findAllQuery";
    public static final String FIND_BY_ID = "application_findAByIdQuery";
    public static final String ID_PARAM = "id";

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "descr")
    private String descr;
    
    @OneToMany(mappedBy = "app", cascade = {PERSIST, MERGE, REFRESH}) 
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public List<ApplicationRoleEntity> getAppRoles() {
        if(appRoles == null) {
            appRoles = new ArrayList<ApplicationRoleEntity>();
        }
        return appRoles;
    }

    public void setAppRoles(List<ApplicationRoleEntity> appRoles) {
        this.appRoles = appRoles;
    }
}
