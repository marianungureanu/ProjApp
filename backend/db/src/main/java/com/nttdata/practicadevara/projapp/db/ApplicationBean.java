package com.nttdata.practicadevara.projapp.db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    }

    public String findAllNamedQuery() {
        return ApplicationEntity.FIND_ALL;
    }

    public String findByIdNamedQuery() {
        return ApplicationEntity.FIND_BY_ID;
    }

    public ApplicationEntity findById(int id) throws DbException {
        ApplicationEntity entity = (ApplicationEntity) manager
                .createNamedQuery(findByIdNamedQuery())
                .setParameter(ApplicationEntity.ID_PARAM, id)
                .getSingleResult();
        if (entity == null) {
            throw new DbException("NOT FOUND ApplicationEntity " + id);
        }
        return entity;
    }

    public ApplicationEntity create(ApplicationEntity entity) {
        manager.persist(entity);
        manager.flush();
        return entity;
    }

    public void delete(int id) {
        Query query = manager.createQuery("Delete FROM ApplicationEntity app WHERE app.id=:id ");
        query.setParameter("id", id);
        query.executeUpdate();
        manager.flush();
    }

    public ApplicationEntity update(ApplicationEntity entity) {
        // TODO: to be implemented
        return null;
    }

    private ApplicationEntity updateWithoutExistanceCheck(ApplicationEntity entity) {
        entity = manager.merge(entity);
        manager.flush();
        return entity;
    }

    private ApplicationEntity checkExistance(ApplicationEntity entity) throws DbException {
        ApplicationEntity object = null;
        if (entity != null) {
            object = findById(entity.getId());
        }
        return object;
    }
}
