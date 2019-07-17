package com.nttdata.practicadevara.projapp.ejb;

import static com.nttdata.practicadevara.projapp.ejb.DtoUtility.*;

import com.nttdata.practicadevara.projapp.db.LevelBean;
import com.nttdata.practicadevara.projapp.db.LevelEntity;
import com.nttdata.practicadevara.projapp.shared.dto.LevelDto;
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
public class LevelEjb {

    @EJB
    private LevelBean levelDbBean;

    public List<LevelDto> list() {
        List<LevelEntity> entities = levelDbBean.findAll();
        return toDtoLevelList(entities);
    }

    public LevelDto create(LevelDto dto) {
        LevelEntity lvl = fromDto(dto);
        levelDbBean.create(lvl);
        return toDto(lvl);
    }

    public void delete(int id) {
        levelDbBean.delete(id);
    }


    /*public LevelDto update(LevelDto dto) {
        LevelEntity l = fromDto(dto);
        LevelEntity lvl = levelDbBean.update(l);
        return toDto(lvl);
    }*/
}
