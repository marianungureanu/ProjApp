package com.nttdata.practicadevara.projapp.db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class RoleBean {
    //private static final long serialVersionUID = 117223295272084434L;

    public static final String SCHEMA_NAME = "projappdb";

    @PersistenceContext(unitName = "projapp-persistenceunit") //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public List<RoleEntity> findAll() {
        return manager.createNamedQuery(findAllNamedQuery()).getResultList();
    }

    public RoleEntity findById(int id) {
        TypedQuery<RoleEntity> q = manager.createNamedQuery(findByIdNamedQuery(), RoleEntity.class);
        q.setParameter("id", id);
        RoleEntity roleEntity = q.getSingleResult();
        return roleEntity;
    }

    public String findAllNamedQuery() {
        return RoleEntity.FIND_ALL;
    }

    public String findByIdNamedQuery() {
        return RoleEntity.FIND_BY_ID;
    }

    public RoleEntity create(RoleEntity rl) {
        manager.persist(rl);
        manager.flush();
        return rl;
    }

    public RoleEntity update(RoleEntity entity) throws DbException {
        checkExistance(entity);
        return updateWithoutExistanceCheck(entity);
    }

    private RoleEntity updateWithoutExistanceCheck(RoleEntity entity) {
        entity = manager.merge(entity);
        return entity;
    }

    private RoleEntity checkExistance(RoleEntity entity) throws DbException {
        RoleEntity object = null;
        if (entity != null) {
            object = findById(entity.getId());
        }
        return object;
    }

}
