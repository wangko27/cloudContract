/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

/**
 * 抽象的DAO类
 *
 * @author sobranie
 */
public abstract class AbstractDAO<T> extends AbstractReadDAO<T> {

    public AbstractDAO(Class<T> entityClass) {
        super(entityClass);
    }

    /**
     * create new entity
     *
     * @param entity
     * @return
     */
    public T create(T entity) {
        EntityManager em = getEntityManager();
        em.persist(entity);
        em.flush();
        em.refresh(entity, LockModeType.PESSIMISTIC_READ);
        return entity;
    }

    /**
     * update entity, create new if not exist
     *
     * @param entity
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * remote entity
     *
     * @param entity
     */
    public void remove(T entity) {
        EntityManager em = getEntityManager();
        em.remove(em.merge(entity));
    }

    /**
     * remove entity by unique id
     *
     * @param id
     */
    public void removeById(Object id) {
        EntityManager em = getEntityManager();
        T t = em.find(entityClass, id);
        if (t != null) {
            em.remove(em.merge(t));
        }
    }
}
