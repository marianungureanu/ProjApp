package com.nttdata.practicadevara.projapp.shared.dto;

/**
 *
 * @author liviu.dima
 */
public class EmployeeTechnologyDto {
    private static final long serialVersionUID = 10005;
    
    /**
     * The id for db operations
     */
    private int id;
    
    /**
     * The technology current skill refers to.
     */
    private TechnologyDto technology;
    
    /**
     * The level the employee masters bound technology
     */
    private LevelDto level;

   
    public EmployeeTechnologyDto(){
        
    }
    public EmployeeTechnologyDto(int id, TechnologyDto technology, LevelDto level){
        this.id = id;
        this.technology = technology;
        this.level = level;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    


    public TechnologyDto getTechnology() {
        return technology;
    }

    public void setTechnology(TechnologyDto technology) {
        this.technology = technology;
    }

    public LevelDto getLevel() {
        return level;
    }

    public void setLevel(LevelDto level) {
        this.level = level;
    }
    
   
}