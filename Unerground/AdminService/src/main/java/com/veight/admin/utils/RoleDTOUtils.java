package com.veight.admin.utils;

import com.veight.admin.entities.RoleModel;
import com.veight.common.security.enums.Authority;
import com.veight.admin.model.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youyou
 */
public class RoleDTOUtils {

    public static Role getDTO(RoleModel model, List<Authority> authorities) {
        Role result = null;
        if (model != null) {
            result = new Role(
                    model.getId(),
                    model.getName(),
                    model.getIsSystem(),
                    model.getDescription(),
                    model.getAuthorities());
            result.setCreateDate(model.getCreateDate());
            result.setModifyDate(model.getModifyDate());
            result.setAuthorities(authorities);
        }
        return result;
    }

    public static Role getDTO(RoleModel model) {
        Role result = null;
        if (model != null) {
            result = new Role(
                    model.getId(),
                    model.getName(),
                    model.getIsSystem(),
                    model.getDescription(),
                    model.getAuthorities());
            result.setCreateDate(model.getCreateDate());
            result.setModifyDate(model.getModifyDate());
        }
        return result;
    }

    public static RoleModel converDTO(Role role) {
        RoleModel result = null;
        if (role != null) {
            result = new RoleModel(role.getName(),
                    role.getIsSystem(),
                    role.getDescription(),
                    role.getAuthorities());
        }
        return result;
    }
}
