package com.nttdata.practicadevara.projapp.shared.dto;

import java.io.Serializable;

/**
 *
 * @author ovidiu.hulea
 */
public class LevelDto implements Serializable{
    private static final long serialVersionUID = 10006;
    
    private int id;
    private String name;

    public LevelDto() {
    }

    public LevelDto(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
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
