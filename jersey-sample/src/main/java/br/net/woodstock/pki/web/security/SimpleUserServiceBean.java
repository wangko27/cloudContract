/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.woodstock.pki.web.security;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.apache.shiro.jersey.sample.realm.User;

/**
 *
 * @author Administrator
 */
@Remote
@Stateless
public class SimpleUserServiceBean implements SimpleUserService {

    public User getByUsernamePassword(String username, String password) {
	System.out.println("SimpleUserServiceBean username " +username);
	System.out.println("SimpleUserServiceBean password"+password);
	return new User("root", "admin");
    }
}
