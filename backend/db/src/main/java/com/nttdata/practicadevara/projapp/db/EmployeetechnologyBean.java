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
     
    /*
      public List<EmployeetechnologyEntity> EmpTechTable() {
        TypedQuery<EmployeetechnologyEntity> query = manager.createQuery("SELECT emp FROM EmployeetechnologyEntity emp", EmployeetechnologyEntity.class);
          List<EmployeetechnologyEntity> resultList = query.getResultList();
       return resultList;
    } 
      
        public List<EmployeetechnologyEntity> findById(int id){
        TypedQuery<EmployeetechnologyEntity> queryID = manager.createQuery("SELECT empID FROM EmployeetechnologyEntity empID WHERE empID.employee.id = :id", EmployeetechnologyEntity.class);
        queryID.setParameter("id",id);
        List<EmployeetechnologyEntity> emplEntity = queryID.getResultList();
        return emplEntity;
    }
*/
    
      public List<EmployeetechnologyEntity> findById(int id){
        TypedQuery<EmployeetechnologyEntity> queryID = manager.createNamedQuery(findByIdNamedQuery(), EmployeetechnologyEntity.class);
        queryID.setParameter("id", id);
        List<EmployeetechnologyEntity> empTechEntity = queryID.getResultList();
        return empTechEntity;
    }
        
    public List<EmployeetechnologyEntity> findAll() {
        return manager.createNamedQuery(findAllNamedQuery()).getResultList();
    }
    /*
    public List<EmployeetechnologyEntity> findById(){
        return manager.createNamedQuery(findByIdNamedQuery()).getResultList();
    }
*/
    public String findAllNamedQuery() {
        return EmployeetechnologyEntity.FIND_ALL;
    }
    
    public String findByIdNamedQuery(){
        return EmployeetechnologyEntity.FIND_BY_ID;
    }
    

}
