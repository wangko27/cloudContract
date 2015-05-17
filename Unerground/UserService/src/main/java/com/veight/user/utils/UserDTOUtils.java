/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.user.utils;

import com.veight.user.entities.UserModel;
import com.veight.user.model.User;
import java.util.Date;

/**
 *
 * @author youyou
 */
public class UserDTOUtils {

    public static User getDTO(UserModel model) {
        User result = null;
        if (model != null) {
            result = new User(model.getId(),
                    model.getUsername(),
                    model.getName(),
                    model.getMobile(),
                    model.getIdNumber(),
                    model.getEmail(),
                    model.getLockedDate(),
                    model.getRegisterIp(),
                    model.getLoginIp(),
                    model.getLoginDate(),
                    model.getBirthday());
            result.setCreateDate(model.getCreateDate());
            result.setModifyDate(model.getModifyDate());
        }
        return result;
    }
}
