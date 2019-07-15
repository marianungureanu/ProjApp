package com.nttdata.practicadevara.projapp.db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class EmployeeBean {

    private static final long serialVersionUID = 117223295272084434L;
    public static final String SCHEMA_NAME = "projappdb";

    @PersistenceContext(unitName = "projapp-persistenceunit") //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public List<EmployeeEntity> findAll() {
        return manager.createNamedQuery(findAllNamedQuery()).getResultList();
    }

    public EmployeeEntity findById(int id) {
        TypedQuery<EmployeeEntity> q = manager.createNamedQuery(findOneNamedQuery(), EmployeeEntity.class);
        q.setParameter("id", id);
        EmployeeEntity emplEntity = q.getSingleResult();
        return emplEntity;
    }

    public String findAllNamedQuery() {
        return EmployeeEntity.FIND_ALL;
    }

    public String findOneNamedQuery() {
        return EmployeeEntity.FIND_ONE;
    }

    public EmployeeEntity create(EmployeeEntity emp) {
        manager.persist(emp);
        manager.flush();
        return emp;
    }

}
