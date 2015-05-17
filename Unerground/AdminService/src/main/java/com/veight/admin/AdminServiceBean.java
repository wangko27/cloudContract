/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.admin;

import com.veight.admin.bean.AdminLoginResult;
import com.veight.admin.bean.enums.LoginResult;
import com.veight.admin.entities.AdminModel;
import com.veight.admin.entities.RoleModel;
import com.veight.admin.entities.dao.AdminDao;
import com.veight.admin.entities.dao.RoleDao;
import com.veight.common.security.enums.Authority;
import com.veight.admin.model.Admin;
import com.veight.admin.model.Role;
import com.veight.admin.utils.AdminDTOUtils;
import com.veight.admin.utils.RoleDTOUtils;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import com.veight.common.security.SecurityUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author youyou
 */
@Remote
@Stateless
public class AdminServiceBean implements AdminService {

    @Inject
    Logger logger;

    @EJB
    ApplicationBean appBean;

    @EJB
    private AdminDao adminDao;

    @EJB
    private RoleDao roleDao;

    @Override
    public Admin findById(String id) {
        AdminModel model = adminDao.find(id);
        Set<Role> roles = new HashSet<>();
        for (RoleModel role : model.getRoles()) {
            roles.add(RoleDTOUtils.getDTO(role));
        }
        return AdminDTOUtils.getDTO(model, roles);
    }

    @Override
    public Page<Admin> findByPage(Pageable pageable) {
        List<Admin> content = new ArrayList<>();

        Page<AdminModel> adminEntites = adminDao.findPage(pageable);

        for (AdminModel model : adminEntites.getContent()) {
            content.add(AdminDTOUtils.getDTO(model));
        }
        return new Page<>(content, adminEntites.getTotal(), adminEntites.getPageable());
    }

    @Override
    public List<Admin> findList(String... ids) {
        List<Admin> result = new ArrayList<Admin>();
        if (ids != null) {
            for (String id : ids) {
                Admin entity = findById(id);
                if (entity != null) {
                    result.add(entity);
                }
            }
        }
        return result;
    }

    @Override
    public void create(Admin admin) {
        AdminModel model = AdminDTOUtils.converDTO(admin);
        String password = admin.getPassword();
        if (password.isEmpty()) {
            //随机密码
            String randomPassword = SecurityUtils.randomPassword();
            logger.debug(admin.getUsername() + " randomPassword is {}", randomPassword);
            password = appBean.getSystemConfig().isDevelopMode() ? appBean.getSystemConfig().getDefaultPassword() : randomPassword;
        } else {
            logger.debug(admin.getUsername() + " password is {}", password);
        }
        model.passphrase(password);
        logger.debug("model admin {}", model);
        adminDao.persist(model);
    }

    @Override
    public AdminLoginResult login(String username, String password) {
        AdminModel model = adminDao.login(username, password);
        if (model == null) {
            logger.warn("login not exist, or password unmatch.[username={}]", username);
            //记录登录日志 todo
            return new AdminLoginResult(LoginResult.FAILED, null);
        }
        if (!model.getIsEnabled()) {
            //管理员禁用
            //记录登录日志 todo
            return new AdminLoginResult(LoginResult.EMPLOYEE_DISABLED, null);
        }
        //在返回之前要记录登录日志 观察是否存在暴力攻击现象
        //TOdo ..
        return new AdminLoginResult(LoginResult.SUCCESSFUL, AdminDTOUtils.getDTO(model));
    }

    @Override
    public void grantRoles(String id, String... roleIds) {
        AdminModel model = adminDao.find(id);
        if (model != null) {
            for (RoleModel originRole : model.getRoles()) {
                logger.debug("originRole {}", originRole);
//                originRole.getAdmins().remove(model);

            }
            model.getRoles().clear();
            for (String roleId : roleIds) {
                logger.debug("role ID is {}", roleId);
                RoleModel role = roleDao.find(roleId);
                logger.debug("role  {}", role);
                if (role != null) {
                    logger.debug("role not null  {}", role);
                    model.getRoles().add(role);
//                    role.getAdmins().add(model);
//                    roleDao.merge(role);
                } else {
                    //nothing
                }
            }
            adminDao.merge(model);
        }
    }

    /**
     * 查找出用户拥有角色的权限信息
     *
     * @param username
     * @return
     */
    public List<Authority> findAuthorities(String username) {
        List<Authority> authorities = new ArrayList<>();
        AdminModel model = adminDao.findByUsername(username);
        if (model != null) {
            for (RoleModel roleModel : model.getRoles()) {
                authorities.addAll(roleModel.getAuthorities());
            }
        }
        return authorities;
    }

    /**
     * 修改密码
     *
     * @param id
     * @param password
     * @return
     */
    @Override
    public boolean resetPassword(String id, String password) {
        AdminModel model = adminDao.find(id);
        if (model != null) {
            model.passphrase(password);
            adminDao.merge(model);
            return true;
        } else {
            logger.debug("admin not exist id {}", id);
            return false;
        }
    }

    @Override
    public boolean disable(String id) {
        AdminModel model = adminDao.find(id);
        if (model != null) {
            if (model.getIsEnabled()) {
                model.setIsEnabled(Boolean.FALSE);
            } else {
                model.setIsEnabled(Boolean.TRUE);
            }
            adminDao.merge(model);
            return true;
        } else {
            logger.debug("admin not exist id {}", id);
            return false;
        }
    }
}
