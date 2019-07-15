/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nttdata.practicadevara.projapp.db;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author eduard.ioo
 */
@Stateless
public class SubscriptionBean {

    public static final String SCHEMA_NAME = "projappdb";

    @PersistenceContext(unitName = "projapp-persistenceunit") //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public List<SubscriptionEntity> findAll(int appRoleId, int employeeId) {
        if (employeeId > 0) {
            return findAllByEmployee(appRoleId, employeeId);
        }
        return manager.createNamedQuery(findAllNamedQuery()).setParameter("id", appRoleId).getResultList();
    }

    public List<SubscriptionEntity> findAllByEmployee(int appRoleId, int empId) {
        return manager
                .createNamedQuery(SubscriptionEntity.FIND_ALL_BY_EMPLOYEE)
                .setParameter("idapprole", appRoleId)
                .setParameter("idemp", empId)
                .getResultList();
    }
    
    
    public List<SubscriptionEntity> findAllSubscriptions() {
        return manager.createNamedQuery(SubscriptionEntity.FIND_ALL_SUBSCRIPTIONS).getResultList();
    }


    public String findAllNamedQuery() {
        return SubscriptionEntity.FIND_ALL;
    }
}
