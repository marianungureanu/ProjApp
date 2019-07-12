
package com.nttdata.practicadevara.projapp.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Stateless
public class ApplicationRolesTechnologiesBean {
    
    public static final String SCHEMA_NAME = "projappdb";

    @PersistenceContext(unitName = "projapp-persistenceunit") //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public List<ApplicationRolesTechnologiesEntity> findAll() {
        return manager.createNamedQuery(findAllNamedQuery()).getResultList();
    }
    
     public List<ApplicationRolesTechnologiesEntity> technologyTable() {
         
        TypedQuery<ApplicationRolesTechnologiesEntity> query = manager.createQuery("SELECT art.id,  art.idApplicationRole.idapp.name,art.idApplicationRole.idapp.descr,art.idApplicationRole.idrole.name, art.idTechnology.name, art.idLevelMin.name FROM ApplicationRolesTechnologiesEntity art", ApplicationRolesTechnologiesEntity.class);
          List<ApplicationRolesTechnologiesEntity> resultList = query.getResultList();
       return resultList;
    }

    public String findAllNamedQuery() {
        return ApplicationRolesTechnologiesEntity.FIND_ALL;
    }
}
