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
public class ApplicationRoleDto {
    private static final long serialVersionUID = 10001;
    private int id;
    private int idapp;
    private int idrole;
    public ApplicationRoleDto(){
        
    }
    
    public ApplicationRoleDto(int id, int idapp, int role){
        this.id=id;
        this.idapp=idapp;
        this.idrole=idrole;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getIdapp(){
       return idapp; 
    }
    
    public void setIdapp(int idapp){
        this.idapp=idapp;
    }
    
    public int getIdrole(){
        return idrole;
    }
    
    public void setIdrole(int idrole){
        this.idrole=idrole;
    }
}
