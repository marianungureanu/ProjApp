package com.nttdata.practicadevara.projapp.shared.dto;

/**
 *
 * @author liviu.dima
 */
public class ApplicationRoleTechnologyDto {

    public static final long serialVersionUID = 10003;
    
    /**
     * The id for ApplicationRoleTechnology
     */
    private int id;
    
    /**
     * The technology for the bound role
     */
    private TechnologyDto technology;
    
    /**
     * The minimum level desired for the given technology
     */
    private LevelDto minLevel;

    public ApplicationRoleTechnologyDto() {

    }

    public ApplicationRoleTechnologyDto(int id, TechnologyDto tech, LevelDto minLevel) {
        this.id = id;
        this.technology = tech;
        this.minLevel = minLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TechnologyDto getTechnology() {
        return technology;
    }

    public void setTechnology(TechnologyDto technology) {
        this.technology = technology;
    }

    public LevelDto getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(LevelDto minLevel) {
        this.minLevel = minLevel;
    }

    
}
