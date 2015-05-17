/*
 * 
 * 
 * 
 */
package com.veight.admin.entities.dao.impl;

import com.veight.admin.entities.AdminModel;
import com.veight.admin.entities.dao.AdminDao;
import com.veight.common.dao.impl.BaseDaoImpl;
import com.veight.common.security.SecurityUtils;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.FlushModeType;
import javax.persistence.NoResultException;

/**
 * Dao - 管理员
 *
 *
 *
 */
@Stateless
public class AdminDaoImpl extends BaseDaoImpl<AdminModel, String> implements AdminDao {

    @Override
    public boolean usernameExists(String username) {
        if (username == null) {
            return false;
        }
        String jpql = "select count(*) from AdminModel admin where lower(admin.username) = lower(:username)";
        Long count = entityManager.createQuery(jpql, Long.class).setFlushMode(FlushModeType.COMMIT).setParameter("username", username).getSingleResult();
        return count > 0;
    }

    @Override
    public AdminModel findByUsername(String username) {
        if (username == null) {
            return null;
        }
        try {
            String jpql = "select admin from AdminModel admin where lower(admin.username) = lower(:username)";
            return entityManager.createQuery(jpql, AdminModel.class).setFlushMode(FlushModeType.COMMIT).setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public AdminModel login(final String username, final String password) {
        AdminModel target = findByUsername(username);
        if (target != null && SecurityUtils.matchPassphrase(target.getPassword(), target.getSalt(), password)) {
            target.setLoginDate(new Date());
            target.setLoginFailureCount(0);
            return target;
        } else {
            return null;
        }
    }

}
