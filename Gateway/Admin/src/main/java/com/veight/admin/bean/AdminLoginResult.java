/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.admin.bean;

import com.veight.admin.bean.enums.LoginResult;
import com.veight.admin.model.Admin;
import com.veight.common.BaseObject;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 管理员登录一次结果 根据LoginResult判断处理
 *
 * @author youyou
 */
@XmlRootElement
public class AdminLoginResult extends BaseObject {

    private static final long serialVersionUID = 20130925L;

    @NotNull
    private LoginResult result;

    private Admin admin;

    public AdminLoginResult(LoginResult result, Admin admin) {
        this.result = result;
        this.admin = admin;
    }

    public LoginResult getResult() {
        return result;
    }

    public void setResult(LoginResult result) {
        this.result = result;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
