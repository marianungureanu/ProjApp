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
public class SubscriptionDto {
    
    private static final long serialVersionUID=10001;
    private int id;
    private String status;
    private int idemp;
    private int idapprl;
    
    public SubscriptionDto(){
        
    }
    
    public SubscriptionDto(int id, String status, int idemp, int idapprl){
        this.id=id;
        this.status=status;
        this.idemp=idemp;
        this.idapprl=idapprl;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status=status;
    }
    
    public int getIdemp(){
        return idemp;
    }
    
    public void setIdemp(int idemp){
        this.idemp=idemp;
    }
    
    public int getIdapprl(){
        return idapprl;
    }
    
    public void setIdapprl(int idapprl){
        this.idapprl=idapprl;
    }
}
