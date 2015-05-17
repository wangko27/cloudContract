/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.admin;

import com.veight.admin.bean.AdminLoginResult;
import com.veight.common.security.enums.Authority;
import com.veight.admin.model.Admin;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import java.util.List;
import javax.ejb.Remote;

/**
 * 管理员操作
 *
 * @author youyou
 */
@Remote
public interface AdminService {

    public Page<Admin> findByPage(Pageable pageable);

    public Admin findById(String id);

    public List<Admin> findList(String... ids);

    public void create(Admin admin);

    public AdminLoginResult login(String username, String password);

    public void grantRoles(String id, String... roleIds);

    public List<Authority> findAuthorities(String username);

    public boolean resetPassword(String id, String password);

    public boolean disable(String id);

}
