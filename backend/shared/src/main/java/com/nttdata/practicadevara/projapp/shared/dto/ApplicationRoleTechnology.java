/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.shared.dto;

/**
 *
 * @author liviu.dima
 */
public class ApplicationRoleTechnology {
    public static final long serialVersionUID=10001;
    private int id;
    private int idapprl;
    private int idtech;
    private int idlvl;
    
    public ApplicationRoleTechnology(){
        
    }
    
    public ApplicationRoleTechnology(int id, int idapprl, int idtech, int idlvl){
        this.id=id;
        this.idapprl=idapprl;
        this.idtech=idtech;
        this.idlvl=idlvl;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getIdapprl(){
        return idapprl;
    }
    
    public void setIdapprl(int idapprl){
        this.idapprl=idapprl;
    }
    
    public int getIdtech(){
        return idtech;
    }
    
    public void setIdtech(int idtech){
        this.idtech=idtech;
    }
    
    public int getIdlvl(){
        return idlvl;
    }
    
    public void setIdlvl(int idlvl){
        this.idlvl=idlvl;
    }
}
