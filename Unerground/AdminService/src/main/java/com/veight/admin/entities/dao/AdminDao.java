/*
 * 
 * 
 * 
 */
package com.veight.admin.entities.dao;

import com.veight.admin.entities.AdminModel;
import com.veight.common.dao.BaseDao;
import javax.ejb.Remote;

/**
 * Dao - 管理员
 *
 *
 *
 */
@Remote
public interface AdminDao extends BaseDao<AdminModel, String> {

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名(忽略大小写)
     * @return 用户名是否存在
     */
    boolean usernameExists(String username);

    /**
     * 根据用户名查找管理员
     *
     * @param username 用户名(忽略大小写)
     * @return 管理员，若不存在则返回null
     */
    AdminModel findByUsername(String username);

    /**
     * 管理员登录
     *
     * @param username
     * @param password 原密码
     * @return
     */
    public AdminModel login(final String username, final String password);

}
