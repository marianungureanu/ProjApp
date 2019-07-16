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
import javax.persistence.TypedQuery;

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

    public SubscriptionEntity findById(int id) {
        TypedQuery<SubscriptionEntity> q = manager.createNamedQuery(findByIdNamedQuery(), SubscriptionEntity.class);
        q.setParameter("id", id);
        SubscriptionEntity subscriptionEntity = q.getSingleResult();
        return subscriptionEntity;
    }

    public String findByIdNamedQuery() {
        return SubscriptionEntity.FIND_BY_ID;
    }

    public SubscriptionEntity update(SubscriptionEntity entity) throws DbException {
        checkExistance(entity);
        return updateWithoutExistanceCheck(entity);
    }

    private SubscriptionEntity updateWithoutExistanceCheck(SubscriptionEntity entity) {
        entity = manager.merge(entity);
        return entity;
    }

    private SubscriptionEntity checkExistance(SubscriptionEntity entity) throws DbException {
        SubscriptionEntity object = null;
        if (entity != null) {
            object = findById(entity.getId());
        }
        return object;
    }
}
