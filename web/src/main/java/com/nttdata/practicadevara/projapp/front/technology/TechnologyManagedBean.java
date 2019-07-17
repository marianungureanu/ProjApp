package com.nttdata.practicadevara.projapp.front.technology;

import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("technologyMBean")
public class TechnologyManagedBean implements Serializable {

    private static final long serialVersionUID = 10001;

    @EJB
    private TechnologyRest technologyRest;

    private TechnologyDto selected;
    private boolean isCreate;
    private boolean isEdit;

    /**
     * Creates a new instance
     */
    public TechnologyManagedBean() {
    }

    public List<TechnologyDto> getTechnologies() {
        return technologyRest.listTechnologies();
    }
    
    public List<TechnologyDto> getTechnologiesWithFirstEmpty() {
        List<TechnologyDto> ret = new ArrayList<>();
        ret.add(new TechnologyDto(0, ""));
        ret.addAll(technologyRest.listTechnologies());
        return ret;
    }
    
    public String startIndex() {
        isEdit = false;
        isCreate = false;
        return "";
    }

    public TechnologyDto getSelected() {
        return selected;
    }

    public void setSelected(TechnologyDto selectedTechnology) {
        this.selected = selectedTechnology;
    }

    public String startEdit() {
        isEdit = true;
        isCreate = false;
        return "";
    }

     public boolean isIsIndex() {
        return !isCreate && !isEdit;
    }

    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public String edit() {
        technologyRest.update(selected);
        selected = null;
        isEdit = false;
        return "";
    }

    public String create() {
        technologyRest.create(selected);
        selected = null;
        isCreate = false;
        return "";
    }
    
     public String startCreate() {
        isEdit = false;
        isCreate = true;
        selected = new TechnologyDto();
        return ""; 
    }
     
     public String delete() {
        technologyRest.delete(selected);
        selected = null;
        return "";
    }
     
    
     
}
