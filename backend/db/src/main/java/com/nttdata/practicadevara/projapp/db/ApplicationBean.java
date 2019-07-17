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
        try {
            entity.getAppRoles().forEach((ar) -> {
                manager.persist(ar);
            });
            manager.persist(entity);
        } catch (javax.validation.ConstraintViolationException e) {
            e.getConstraintViolations().forEach(err -> System.err.println(err.toString()));
        }
        manager.flush();
        return entity;
    }

    public ApplicationEntity update(ApplicationEntity entity) throws DbException {
        checkExistance(entity);
        return updateWithoutExistanceCheck(entity);
    }

    public void delete(int id) {
        ApplicationEntity entity = manager.find(ApplicationEntity.class, id);
        try {
            entity.getAppRoles().forEach((appRole) -> {
                manager.remove(appRole);
            });
            manager.remove(entity);
        } catch (javax.validation.ConstraintViolationException e) {
            e.getConstraintViolations().forEach(err -> System.err.println(err.toString()));
        }
        manager.flush();
    }

    private ApplicationEntity updateWithoutExistanceCheck(ApplicationEntity entity) {
        try {
            entity = manager.merge(entity);
        } catch (javax.validation.ConstraintViolationException e) {
            e.getConstraintViolations().forEach(err -> System.err.println(err.toString()));
        }

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
