/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.user;

import com.veight.common.query.page.Page;
import com.veight.common.query.page.Pageable;
import com.veight.user.model.User;
import javax.ejb.Remote;

/**
 *
 * @author youyou
 */
@Remote
public interface UserService {

    public Page<User> findByPage(Pageable pageable);
    
    public void create(User user);
}
