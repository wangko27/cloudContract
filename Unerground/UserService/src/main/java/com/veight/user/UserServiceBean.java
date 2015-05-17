/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.user;

import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import com.veight.user.dao.UserDao;
import com.veight.user.entities.UserModel;
import com.veight.user.model.User;
import com.veight.user.security.dimmer.UserDimmer;
import com.veight.user.utils.UserDTOUtils;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author youyou
 */
@LocalBean
@Stateless
public class UserServiceBean implements UserService {

    @EJB
    private UserDao userDao;

    @Override
    public Page<User> findByPage(Pageable pageable) {
        List<User> content = new ArrayList<>();

        Page<UserModel> roleEntites = userDao.findPage(pageable);

        for (UserModel model : roleEntites.getContent()) {
            User user = UserDTOUtils.getDTO(model);
            user = UserDimmer.dim(user);
            content.add(user);
        }
        return new Page<>(content, roleEntites.getTotal(), roleEntites.getPageable());
    }

    @Override
    public void create(User user) {
        //需要 密码加密存储
        
        UserModel model = new UserModel(user.getUsername(), user.getName(), "123456", user.getEmail(), user.getRegisterIp());
        userDao.persist(model);
    }

}
