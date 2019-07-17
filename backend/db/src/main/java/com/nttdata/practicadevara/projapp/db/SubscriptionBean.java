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

    public SubscriptionEntity findById(int id) {
        return manager.find(SubscriptionEntity.class, id);
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
    
    public SubscriptionEntity create(SubscriptionEntity subs) {
        manager.persist(subs);
        manager.flush();
        return subs;
    }
    
    public void delete(SubscriptionEntity subs) throws DbException {
        checkExistance(subs);
        manager.remove(subs);
        manager.flush();
    }

    private SubscriptionEntity checkExistance(SubscriptionEntity entity) throws DbException {
        SubscriptionEntity object = null;
        if (entity != null) {
            object = findById(entity.getId());
        }
        return object;
    }
}
