/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.admin.model;

import com.veight.common.TimeScopeBaseObject;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author youyou
 */
@Data
@NoArgsConstructor
@XmlRootElement
public class Admin extends TimeScopeBaseObject {

    protected String id;
    /**
     * 获取用户名
     *
     * @return 用户名
     */
    private String username;

    /**
     * 获取密码
     *
     * @return 密码
     */
    private String password;

    /**
     * 获取E-mail
     *
     * @return E-mail
     */
    private String email;

    private String mobile;

    /**
     * 姓名
     */
    private String name;

    /**
     * 获取部门
     *
     * @return 部门
     */
    private String department;

    /**
     * 获取是否启用
     *
     * @return 是否启用
     */
    private Boolean isEnabled = true;

    /**
     * 是否锁定
     */
    private Boolean isLocked = false;

    /**
     * 获取连续登录失败次数
     *
     * @return 连续登录失败次数
     */
    private Integer loginFailureCount = 0;

    /**
     * 锁定日期
     */
    private Date lockedDate;

    /**
     * 最后登录日期
     */
    private Date loginDate;

    /**
     * 最后登录IP
     */
    private String loginIp;

    /**
     * 获取角色
     *
     * @return 角色
     */
    private Set<Role> roles = new HashSet<Role>();

    public Admin(String id, String username, String password, String email, String name, String department, Date lockedDate, Date loginDate, String loginIp, Date createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.department = department;
        this.lockedDate = lockedDate;
        this.loginDate = loginDate;
        this.loginIp = loginIp;
        this.createDate = createDate;
    }

    public Admin(String username, String password, String email, String name, String mobile, String department) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.mobile = mobile;
        this.department = department;
    }

    public Admin(String username, String password, String email, String name, String department) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.department = department;
    }

}
