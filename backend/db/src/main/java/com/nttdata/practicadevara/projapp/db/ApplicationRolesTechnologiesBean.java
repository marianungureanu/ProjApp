
package com.nttdata.practicadevara.projapp.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class ApplicationRolesTechnologiesBean {
    
    public static final String SCHEMA_NAME = "projappdb";

    @PersistenceContext(unitName = "projapp-persistenceunit") //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public List<ApplicationRolesTechnologiesEntity> findAll() {
        return manager.createNamedQuery(findAllNamedQuery()).getResultList();
    }

    public String findAllNamedQuery() {
        return ApplicationRolesTechnologiesEntity.FIND_ALL;
    }
}
