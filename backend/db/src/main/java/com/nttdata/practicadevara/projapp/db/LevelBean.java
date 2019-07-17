package com.nttdata.practicadevara.projapp.db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

    /*
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
    */
      public LevelEntity findById(int id) {
        TypedQuery<LevelEntity> q = manager.createNamedQuery(findByIdNamedQuery(), LevelEntity.class);
        q.setParameter("id", id);
        LevelEntity levelEntity = q.getSingleResult();
        return levelEntity;
    }


    public String findAllNamedQuery() {
        return LevelEntity.FIND_ALL;
    }

    public String findByIdNamedQuery() {
        return LevelEntity.FIND_BY_ID;
    }

    public void delete(int id) {
        LevelEntity lvl = manager.find(LevelEntity.class, id);
        manager.remove(lvl);
        manager.flush();
    }
    
   public LevelEntity update(LevelEntity entity) throws DbException {
        checkExistance(entity);
        return updateWithoutExistanceCheck(entity);
    }
   
    private LevelEntity updateWithoutExistanceCheck(LevelEntity entity) {
        entity = manager.merge(entity);
        return entity;
    }

    private LevelEntity checkExistance(LevelEntity entity) throws DbException {
        LevelEntity object = null;
        if (entity != null) {
            object = findById(entity.getId());
        }
           return object;
    }
    
   
}
