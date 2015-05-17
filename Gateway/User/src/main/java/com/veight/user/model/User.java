/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.user.model;

import com.veight.common.TimeScopeBaseObject;
import com.veight.user.model.enums.Gender;
import java.util.Date;
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
public class User extends TimeScopeBaseObject {

    private String id;

    private String username;

    private String password;

    private String name;

    private String mobile;

    private String idNumber;
    /**
     * E-mail
     */
    private String email;

    /**
     * 是否启用
     */
    private Boolean isEnabled = true;

    /**
     * 是否锁定
     */
    private Boolean isLock = false;

    /**
     * 连续登录失败次数
     */
    private Integer loginFailureCount = 0;

    /**
     * 锁定日期
     */
    private Date lockedDate;

    /**
     * 注册IP
     */
    private String registerIp;

    /**
     * 最后登录IP
     */
    private String loginIp;

    /**
     * 最后登录日期
     */
    private Date loginDate;

    /**
     * 性别
     */
    private Gender gender = Gender.male;

    /**
     * 出生日期
     */
    private Date birthday;

    public User(String name, String username, String password, String email, String mobile, String registerIp) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.registerIp = registerIp;
    }

    public User(String id, String username, String name, String mobile, String idNumber, String email, Date lockedDate, String registerIp, String loginIp, Date loginDate, Date birthday) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.mobile = mobile;
        this.idNumber = idNumber;
        this.email = email;
        this.lockedDate = lockedDate;
        this.registerIp = registerIp;
        this.loginIp = loginIp;
        this.loginDate = loginDate;
        this.birthday = birthday;
    }
}
