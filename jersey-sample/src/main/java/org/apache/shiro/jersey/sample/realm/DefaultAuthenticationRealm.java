/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.shiro.jersey.sample.realm;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 *
 * @author Administrator
 */
public class DefaultAuthenticationRealm extends AuthorizingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	UsernamePasswordToken authenticationToken = (UsernamePasswordToken) token;
	String username = authenticationToken.getUsername();
	String password = new String(authenticationToken.getPassword());
	System.out.println("username :" + username);
	System.out.println("password :" + password);
	System.out.println("用户名密码匹配");
	return new SimpleAuthenticationInfo("admin", password, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	String principal = (String) principals.fromRealm(getName()).iterator().next();
	System.out.println("principal " + principal);
	if (principal != null) {
	    List<String> authorities = new ArrayList<String>();
	    authorities.add("admin:admin");
	    if (authorities != null) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(authorities);
		authorizationInfo.addRole("admin");
		return authorizationInfo;
	    }
	}
	return null;
    }
    
    

}
