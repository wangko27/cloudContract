/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.admin.utils;

import com.veight.admin.entities.AdminModel;
import com.veight.admin.model.Admin;
import com.veight.admin.model.Role;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author youyou
 */
public class AdminDTOUtils {

    private static Logger logger = LoggerFactory.getLogger(AdminDTOUtils.class);

    public static Admin getDTO(AdminModel model) {
        Admin result = null;
        if (model != null) {
            result = new Admin(model.getId(),
                    model.getUsername(),
                    model.getPassword(),
                    model.getEmail(),
                    model.getName(),
                    model.getDepartment(),
                    model.getLockedDate(),
                    model.getLoginDate(),
                    model.getLoginIp(),
                    model.getCreateDate());
            result.setIsEnabled(model.getIsEnabled());
        }
        return result;
    }

    public static Admin getDTO(AdminModel model, Set<Role> roles) {
        Admin result = null;
        if (model != null) {
            result = new Admin(model.getId(),
                    model.getUsername(),
                    model.getPassword(),
                    model.getEmail(),
                    model.getName(),
                    model.getDepartment(),
                    model.getLockedDate(),
                    model.getLoginDate(),
                    model.getLoginIp(),
                    model.getCreateDate());
            result.setIsEnabled(model.getIsEnabled());
        }
        if (roles != null && roles.size() > 0) {
            result.setRoles(roles);
        }
        return result;
    }

    public static AdminModel converDTO(Admin admin) {
        AdminModel result = null;
        if (admin != null) {
            result = new AdminModel(admin.getUsername(),
                    admin.getPassword(),
                    admin.getEmail(),
                    admin.getName(),
                    admin.getDepartment(),
                    admin.getLoginIp());
        }
        return result;
    }
}
