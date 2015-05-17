/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.admin.entities.dao.impl;

import com.veight.admin.entities.RoleModel;
import com.veight.admin.entities.dao.RoleDao;
import com.veight.common.dao.impl.BaseDaoImpl;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;

/**
 *
 * @author youyou
 */
@Stateless
public class RoleDaoImpl extends BaseDaoImpl<RoleModel, String> implements RoleDao {

    public Set<RoleModel> getByIds(String... ids) {
        Set<RoleModel> roles = new HashSet<>();
        for (String id : ids) {
            roles.add(this.find(id));
        }
        return roles;
    }

}
