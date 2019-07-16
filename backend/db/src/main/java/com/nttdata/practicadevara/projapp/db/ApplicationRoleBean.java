package com.nttdata.practicadevara.projapp.db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ApplicationRoleBean {

    private static final long serialVersionUID = 117223295272084434L;

    public static final String SCHEMA_NAME = "projappdb";

    @PersistenceContext(unitName = "projapp-persistenceunit") //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public List<ApplicationRoleEntity> findAll() {
        return manager.createQuery("SELECT a.id, a.app, a.role FROM ApplicationRoleEntity a", ApplicationRoleEntity.class).getResultList();
    }
    
    public ApplicationRoleEntity findById(int id) {
        TypedQuery<ApplicationRoleEntity> query = manager.createQuery("SELECT a FROM ApplicationRoleEntity a where a.id = :id", ApplicationRoleEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public void delete(ApplicationRoleEntity e) {
        manager.remove(e);
    }
}
