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
public class EmployeeTechnologyDto {
    private static final long serialVersionUID = 10001;
    private int id;
    private int idemp;
    private int idtech;
    private int idlvl;
    
    public EmployeeTechnologyDto(){
        
    }
    public EmployeeTechnologyDto(int id, int idemp, int idtech, int idlvl){
        this.id=id;
        this.idemp=idemp;
        this.idtech=idtech;
        this.idlvl=idlvl;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getIdemp(){
        return idemp;
    }
    
    public void setIdemp(int idemp){
        this.idemp=idemp;
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
    
    public void setIdlvl(){
        this.idlvl=idlvl;
    }
}
