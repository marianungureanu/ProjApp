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
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author ovidiu.hulea
 */
@Stateless
public class TechnologyBean {

    public static final String SCHEMA_NAME = "projappdb";

    @PersistenceContext(unitName = "projapp-persistenceunit") //see main/resources/META-INF/peristence.xml
    protected EntityManager manager;

    public List<TechnologyEntity> findAll() {
        return manager.createNamedQuery(findAllNamedQuery()).getResultList();
    }

    public TechnologyEntity findById(int id) {
        TypedQuery<TechnologyEntity> q = manager.createNamedQuery(findOneNamedQuery(), TechnologyEntity.class);
        q.setParameter("id", id);
        TechnologyEntity techEntity = q.getSingleResult();
        return techEntity;
    }

    public String findAllNamedQuery() {
        return TechnologyEntity.FIND_ALL;
    }

    public String findOneNamedQuery() {
        return TechnologyEntity.FIND_ONE;
    }

    public TechnologyEntity create(TechnologyEntity entity) {
        manager.persist(entity);
        manager.flush();
        return entity;
    }

    public void delete(int id) {
        TechnologyEntity tech = manager.find(TechnologyEntity.class, id);
        manager.remove(tech);
        manager.flush();

    }

    public TechnologyEntity edit(TechnologyEntity entity) {
        manager.merge(entity);
        manager.flush();
        return entity;
    }
}
