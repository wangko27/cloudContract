/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.shiro.jersey.sample.realm;

import br.net.woodstock.pki.web.security.SimpleUser;

/**
 *
 * @author Administrator
 */
public class User implements SimpleUser {

    private String username;

    private String password;

    public User(String username, String password) {
	this.username = username;
	this.password = password;
    }

    public User() {
    }

    public String[] getRoles() {

	return new String[]{"admin", "root"};
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}
