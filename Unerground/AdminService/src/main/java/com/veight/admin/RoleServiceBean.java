/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.admin;

import com.veight.admin.entities.RoleModel;
import com.veight.admin.entities.dao.RoleDao;
import com.veight.admin.model.Role;
import com.veight.admin.utils.RoleDTOUtils;
import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import java.util.ArrayList;
import java.util.List;
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
public class RoleServiceBean implements RoleService {

    @Inject
    Logger logger;

    @EJB
    private RoleDao roleDao;

    @Override
    public Role findById(String id) {
        RoleModel model = roleDao.find(id);
        return RoleDTOUtils.getDTO(model, model.getAuthorities());
    }

    @Override
    public List<Role> findAll() {
        List<Role> content = new ArrayList<>();
        List<RoleModel> models = roleDao.findList(null, null, null, null);
        for (RoleModel model : models) {
            content.add(RoleDTOUtils.getDTO(model, model.getAuthorities()));
        }
        return content;
    }

    @Override
    public Page<Role> findByPage(Pageable pageable) {
        List<Role> content = new ArrayList<>();

        Page<RoleModel> roleEntites = roleDao.findPage(pageable);

        for (RoleModel model : roleEntites.getContent()) {
            content.add(RoleDTOUtils.getDTO(model, model.getAuthorities()));
        }
        return new Page<>(content, roleEntites.getTotal(), roleEntites.getPageable());
    }

    @Override
    public List<Role> findList(String... ids) {
        List<Role> result = new ArrayList<Role>();
        if (ids != null) {
            for (String id : ids) {
                Role entity = findById(id);
                if (entity != null) {
                    result.add(entity);
                }
            }
        }
        return result;
    }

    @Override
    public void persist(Role role) {

        roleDao.persist(RoleDTOUtils.converDTO(role));
    }

    @Override
    public void update(Role role) {
        logger.debug("update role {}", role);
        RoleModel model = null;
        if (role != null && role.getId() != null) {
            model = roleDao.find(role.getId());
            model.setName(role.getName());
            model.setIsSystem(role.getIsSystem());
            model.setDescription(role.getDescription());
            model.setAuthorities(role.getAuthorities());
            roleDao.merge(model);
        } else {
            logger.error("when update role id is null");
        }
    }
}
