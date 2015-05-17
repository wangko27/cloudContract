/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.user.dao.impl;

import com.veight.common.dao.impl.BaseDaoImpl;
import com.veight.user.dao.UserDao;
import com.veight.user.entities.UserModel;
import javax.ejb.Stateless;

/**
 *
 * @author youyou
 */
@Stateless
public class UserDaoImpl extends BaseDaoImpl<UserModel, String> implements UserDao {

}
