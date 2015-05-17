/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.admin;

import com.veight.admin.model.Role;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author youyou
 */
@Remote
public interface RoleService {

    public Page<Role> findByPage(Pageable pageable);

    public List<Role> findAll();

    public Role findById(String id);

    public List<Role> findList(String... ids);

    public void persist(Role role);

    public void update(Role role);

}
