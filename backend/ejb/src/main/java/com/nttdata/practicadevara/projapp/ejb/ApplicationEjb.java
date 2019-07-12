package com.nttdata.practicadevara.projapp.ejb;

import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;

import com.nttdata.practicadevara.projapp.db.ApplicationBean;
import com.nttdata.practicadevara.projapp.db.ApplicationEntity;
import com.nttdata.practicadevara.projapp.shared.dto.ApplicationDto;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author ovidiu.hulea
 */
@Stateless
@LocalBean
public class ApplicationEjb {

    @EJB
    private ApplicationBean applicationDbBean;

    public List<ApplicationDto> list() { 
        List<ApplicationEntity> entities = applicationDbBean.findAll();
        return toDtoAppList(entities);
    }
    public ApplicationDto create(ApplicationDto dto) {
        ApplicationEntity e = fromDto(dto);
        ApplicationEntity entity = applicationDbBean.create(e);
        return toDto(entity);
    }

    public ApplicationDto update(ApplicationDto dto) {
        ApplicationEntity e = fromDto(dto);
        ApplicationEntity entity = applicationDbBean.update(e);
        return toDto(entity);
    }
    
    public ApplicationDto delete(ApplicationDto dto){
        ApplicationEntity e = fromDto(dto);
        ApplicationEntity entity = applicationDbBean.delete(e);
        return toDto(entity);
    }
}
