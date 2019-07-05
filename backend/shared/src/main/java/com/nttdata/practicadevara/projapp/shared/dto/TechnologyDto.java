/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.shared.dto;

import java.io.Serializable;

/**
 *
 * @author ovidiu.hulea
 */
public class TechnologyDto  implements Serializable {
    private static final long serialVersionUID = 10001;
    
    private int id;
    private String name;

    public TechnologyDto() {
    }

    public TechnologyDto(int id, String name) {
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
