package br.net.woodstock.pki.web.security;

import javax.ejb.Remote;
import org.apache.shiro.jersey.sample.realm.User;

@Remote
public interface SimpleUserService {

    public User getByUsernamePassword(String username, String password);

}
