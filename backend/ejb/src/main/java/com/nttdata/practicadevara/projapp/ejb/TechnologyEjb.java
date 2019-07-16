package com.nttdata.practicadevara.projapp.ejb;

import com.nttdata.practicadevara.projapp.db.DbException;
import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;

import com.nttdata.practicadevara.projapp.db.TechnologyBean;
import com.nttdata.practicadevara.projapp.db.TechnologyEntity;
import com.nttdata.practicadevara.projapp.shared.dto.TechnologyDto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class TechnologyEjb {

@EJB
    private TechnologyBean technologyDbBean;
    
    public List<TechnologyDto> list() {
        List<TechnologyEntity> entities = technologyDbBean.findAll();
        return toDtoTechnologiesList(entities);
    }
    
    public TechnologyDto findById(int id) {
        TechnologyEntity entity = technologyDbBean.findById(id);
       return toDto(entity);
    }
    
    public TechnologyDto create(TechnologyDto dto) {
       TechnologyEntity entity = fromDto(dto);
       technologyDbBean.create(entity);
       return toDto(entity);
    }

    public void delete(int id){
        technologyDbBean.delete(id);
    }

}
