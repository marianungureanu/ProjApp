package com.nttdata.practicadevara.projapp.db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author sebastian.stoica
 */
@Stateless
public class EmployeetechnologyBean {

    private static final long serialVersionUID = 117223295272084434L;

    public static final String SCHEMA_NAME = "projappdb";

    @PersistenceContext(unitName = "projapp-persistenceunit") //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public List<EmployeetechnologyEntity> findById(int id) {
        TypedQuery<EmployeetechnologyEntity> queryID = manager.createNamedQuery(findByIdNamedQuery(), EmployeetechnologyEntity.class);
        queryID.setParameter("id", id);
        List<EmployeetechnologyEntity> empTechEntity = queryID.getResultList();
        return empTechEntity;
    }

    public List<EmployeetechnologyEntity> findAll() {
        return manager.createNamedQuery(findAllNamedQuery()).getResultList();
    }

    public String findAllNamedQuery() {
        return EmployeetechnologyEntity.FIND_ALL;
    }

    public String findByIdNamedQuery() {
        return EmployeetechnologyEntity.FIND_BY_ID;
    }

    public EmployeetechnologyEntity create(EmployeetechnologyEntity emplteh) {
        manager.persist(emplteh);
        manager.flush();
        return emplteh;
    }

}
