/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.front.levels;

import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author larisa.marin
 */
@SessionScoped
@Named("levelMBean")
public class LevelManagedBean implements Serializable {

    private static final long serialVersionUID = 10001;

    @EJB
    private LevelRest levelRest;
    private LevelDto selected;
    private List<LevelDto> levelList;
    private boolean isCreate;
    private boolean isEdit;
    
    /**
     * Creates a new instance
     */
  
    public LevelManagedBean() {
    }
    
    public void init() {
        levelList = levelRest.listLevel();
    }
    
    public List<LevelDto> getLevels() {
                if (levelList == null) {
            init();
        }
        return levelList;
    }
    
    public boolean isIsIndex() {
        return !isCreate && !isEdit;
    }
    
    
     public void setSelected(LevelDto selectedLevel) {
        this.selected = selectedLevel;
    }
    
    public String startEdit() {
        isEdit = true;
        isCreate = false;
        return "";
    }
    
      public String startCreate() {
        isEdit = false;
        isCreate = true;
        selected = new LevelDto();
        return "";
    }
      
        public String startIndex() {
        isEdit = false;
        isCreate = false;
        return "";
    }
        
        public LevelDto getSelected() {
        return selected;
    }

   
     public String edit() {
        levelRest.update(selected);
        selected = null;
        reload();
        isEdit = false;
        return "";
     }
     
    public String create() {
        levelRest.create(selected);
        selected = null;
        reload();
        isCreate = false;
        return "";
    }
    
    public String delete(){
        levelRest.delete(selected);
        selected=null;
        reload();
        isCreate=false;
        return "";
    }
       public boolean isIsCreate() {
        return isCreate;
    }
    
    public boolean isIsEdit() {
        return isEdit;
    }
    
      public void reload() {
        levelList = null;
    }

    public String toLevelIndex() {
        return "";
    }
}