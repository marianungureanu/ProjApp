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

    private static final String TECHNOLOGY_XHTML = "/admin/index";
    private static final String CREATE_OR_EDIT_XHTML = "/admin/technology/createOrEditTechnology";

    @EJB
    private TechnologyRest technologyRest;

    private TechnologyDto selected;
    private List<TechnologyDto> technologyList;
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

    public TechnologyDto getSelected() {
        return selected;
    }

    public void setSelected(TechnologyDto selectedTechnology) {
        this.selected = selectedTechnology;
    }

    public String startEdit() {
        isEdit = true;
        isCreate = false;
        return CREATE_OR_EDIT_XHTML;
    }

  

    public boolean isIsCreate() {
        return isCreate;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void reload() {
        technologyList = null;
    }

    public String edit() {
        technologyRest.update(selected);
        selected = null;
        reload();
        isEdit = false;
        return TECHNOLOGY_XHTML;
    }

    public String create() {
        technologyRest.create(selected);
        selected = null;
        reload();
        isCreate = false;
        return TECHNOLOGY_XHTML;
    }

    public String toTechnologyIndex() {
        return TECHNOLOGY_XHTML;
    }
    
     public String startCreate() {
        isEdit = false;
        isCreate = true;
        selected = new TechnologyDto();
        return CREATE_OR_EDIT_XHTML; 
        
    }
     
     public String delete() {
        technologyRest.delete(selected);
        selected = null;
        reload();
        return TECHNOLOGY_XHTML;
    }
     
    
     
}
