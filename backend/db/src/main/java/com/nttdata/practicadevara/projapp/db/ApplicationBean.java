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
public class ApplicationBean {

    private static final long serialVersionUID = 117223295272084434L;

    public static final String SCHEMA_NAME = "projappdb";

    @PersistenceContext(unitName = "projapp-persistenceunit") //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public List<ApplicationEntity> findAll() {
        return manager.createNamedQuery(findAllNamedQuery()).getResultList();
//        TypedQuery<ApplicationEntity> query = manager.createQuery("SELECT emp FROM EmployeetechnologyEntity emp", ApplicationEntity.class);
//          List<ApplicationEntity> resultList = query.getResultList();
//       return resultList;
    }

    public String findAllNamedQuery() {
        return ApplicationEntity.FIND_ALL;
    }

    public String findByIdNamedQuery() {
        return ApplicationEntity.FIND_BY_ID;
    }

    public ApplicationEntity findById(int id) {
        return (ApplicationEntity) manager
                .createNamedQuery(findByIdNamedQuery())
                .setParameter(ApplicationEntity.ID_PARAM, id)
                .getSingleResult();
    }

    public ApplicationEntity create(ApplicationEntity entity) {
        manager.persist(entity);
        manager.flush();
        return entity;
    }

    public ApplicationEntity update(ApplicationEntity entity) {
        checkExistance(entity);
        return updateWithoutExistanceCheck(entity);
    }
    
    public ApplicationEntity delete(ApplicationEntity entity){
       return entity;
    }

    private ApplicationEntity updateWithoutExistanceCheck(ApplicationEntity entity) {
        entity = manager.merge(entity);
        return entity;
    }

    private ApplicationEntity checkExistance(ApplicationEntity entity) {
        ApplicationEntity object = null;
        if (entity != null) {
            object = findById(entity.getId());
            if (object == null) {
                //throw new DBException("Entity not found");
            }
        }
        return object;
    }
}
