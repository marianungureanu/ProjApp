package com.nttdata.practicadevara.projapp.db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RoleBean {
    //private static final long serialVersionUID = 117223295272084434L;

    public static final String SCHEMA_NAME = "projappdb";

    @PersistenceContext(unitName = "projapp-persistenceunit") //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public List<RoleEntity> findAll() {
        return manager.createNamedQuery(findAllNamedQuery()).getResultList();
    }

    public RoleEntity findById(int id) throws DbException {
        RoleEntity entity = (RoleEntity) manager
                .createNamedQuery(findByIdNamedQuery())
                .setParameter(ApplicationEntity.ID_PARAM, id)
                .getSingleResult();
        if (entity == null) {
            System.out.println("Role "+id +" not found thrown ex");
            throw new DbException("NOT FOUND RoleEntity " + id);
        }
        return entity;
    }

    public String findAllNamedQuery() {
        return RoleEntity.FIND_ALL;
    }

    public String findByIdNamedQuery() {
        return RoleEntity.FIND_BY_ID;
    }
}
