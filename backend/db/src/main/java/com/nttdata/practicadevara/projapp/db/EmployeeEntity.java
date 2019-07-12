package com.nttdata.practicadevara.projapp.db;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee", schema = EmployeeEntity.SCHEMA_NAME)
@NamedQueries({
    @NamedQuery(name = EmployeeEntity.FIND_ALL, query = "SELECT e FROM EmployeeEntity e"),
    @NamedQuery(name = EmployeeEntity.FIND_ONE, query = "SELECT e FROM EmployeeEntity e WHERE e.id = :id")
})
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 117223295272084434L;

    public static final String SCHEMA_NAME = "projappdb";
    public static final String FIND_ALL = "employee_findAllQuery";
    public static final String FIND_ONE = "employee_findOneQuery";

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
    private List<EmployeetechnologyEntity> employeeTechnology;
    private List<SubscriptionEntity> subscription;
}
