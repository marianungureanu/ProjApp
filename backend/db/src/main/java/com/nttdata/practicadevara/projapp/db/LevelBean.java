package com.nttdata.practicadevara.projapp.db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ovidiu.hulea
 */
@Stateless
public class LevelBean {
    //private static final long serialVersionUID = 117223295272084434L;

    public static final String SCHEMA_NAME = "projappdb";

    @PersistenceContext(unitName = "projapp-persistenceunit") //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public List<LevelEntity> findAll() {
        return manager.createNamedQuery(findAllNamedQuery()).getResultList();
    }

    public LevelEntity create(LevelEntity lvl) {
        manager.persist(lvl);
        manager.flush();
        return lvl;
    }
    

    public LevelEntity findById(int id) throws DbException {
        LevelEntity entity = (LevelEntity) manager
                .createNamedQuery(findByIdNamedQuery(), LevelEntity.class)
                .setParameter(ApplicationEntity.ID_PARAM, id)
                .getSingleResult();
        if (entity == null) {
            throw new DbException("NOT FOUND RoleEntity " + id);
        }
        return entity;
    }

    public String findAllNamedQuery() {
        return LevelEntity.FIND_ALL;
    }

    public String findByIdNamedQuery() {
        return LevelEntity.FIND_BY_ID;
    }
}
