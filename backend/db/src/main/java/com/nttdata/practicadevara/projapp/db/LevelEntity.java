package com.nttdata.practicadevara.projapp.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ovidiu.hulea
 */
@Entity
@Table(name = "Level", schema = EmployeeEntity.SCHEMA_NAME)
@NamedQueries({
    @NamedQuery(name = LevelEntity.FIND_ALL, query = "SELECT l FROM LevelEntity l")
})
public class LevelEntity implements Serializable {

    //private static final long serialVersionUID = 117223295272084434L;
    public static final String SCHEMA_NAME = "projappdb";
    public static final String FIND_ALL = "level_findAllQuery";

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

}
