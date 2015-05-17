package com.veight.common.service.impl;

import com.veight.common.dao.BaseDao;
import com.veight.common.entities.BaseEntity;
import com.veight.common.query.page.Filter;
import com.veight.common.query.page.Order;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import com.veight.common.service.BaseService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

/**
 * Service - 基类
 *
 *
 *
 */
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    /**
     * 更新忽略属性
     */
    private static final String[] UPDATE_IGNORE_PROPERTIES = new String[]{BaseEntity.ID_PROPERTY_NAME, BaseEntity.CREATE_DATE_PROPERTY_NAME, BaseEntity.MODIFY_DATE_PROPERTY_NAME};

    /**
     * baseDao
     */
    private BaseDao<T, ID> baseDao;

    public void setBaseDao(BaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    public T find(ID id) {
        return baseDao.find(id);
    }

    public List<T> findAll() {
        return findList(null, null, null, null);
    }

    public List<T> findList(ID... ids) {
        List<T> result = new ArrayList<T>();
        if (ids != null) {
            for (ID id : ids) {
                T entity = find(id);
                if (entity != null) {
                    result.add(entity);
                }
            }
        }
        return result;
    }

    @Transactional
    public List<T> findList(Integer count, List<Filter> filters, List<Order> orders) {
        return findList(null, count, filters, orders);
    }

    @Transactional
    public List<T> findList(Integer first, Integer count, List<Filter> filters, List<Order> orders) {
        return baseDao.findList(first, count, filters, orders);
    }

    @Transactional
    public Page<T> findPage(Pageable pageable) {
        return baseDao.findPage(pageable);
    }

    @Transactional
    public long count() {
        return count(new Filter[]{});
    }

    @Transactional
    public long count(Filter... filters) {
        return baseDao.count(filters);
    }

    public boolean exists(ID id) {
        return baseDao.find(id) != null;
    }

    public boolean exists(Filter... filters) {
        return baseDao.count(filters) > 0;
    }

    public void save(T entity) {
        baseDao.persist(entity);
    }

    public T update(T entity) {
        return baseDao.merge(entity);
    }

    public T update(T entity, String... ignoreProperties) {
        if (baseDao.isManaged(entity)) {
            throw new IllegalArgumentException("Entity must not be managed");
        }
        T persistant = baseDao.find(baseDao.getIdentifier(entity));
        if (persistant != null) {
            //copyProperties(entity, persistant, (String[]) ArrayUtils.addAll(ignoreProperties, UPDATE_IGNORE_PROPERTIES));
            return update(persistant);
        } else {
            return update(entity);
        }
    }

    @Transactional
    public void delete(ID id) {
        delete(baseDao.find(id));
    }

    @Transactional
    public void delete(ID... ids) {
        if (ids != null) {
            for (ID id : ids) {
                delete(baseDao.find(id));
            }
        }
    }

    @Transactional
    public void delete(T entity) {
        baseDao.remove(entity);
    }

}
