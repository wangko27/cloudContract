/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.user.dao;

import com.veight.common.dao.BaseDao;
import com.veight.user.entities.UserModel;
import javax.ejb.Remote;

/**
 *
 * @author youyou
 */
@Remote
public interface  UserDao extends BaseDao<UserModel, String> {
   
}
