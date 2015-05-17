/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.admin.entities.dao;

import com.veight.admin.entities.RoleModel;
import com.veight.common.dao.BaseDao;
import java.util.Set;
import javax.ejb.Remote;

/**
 *
 * @author youyou
 */
@Remote
public interface RoleDao extends BaseDao<RoleModel, String> {

    public Set<RoleModel> getByIds(String... ids);
}
