/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.user.entities;

import com.veight.common.entities.UUIDEntity;
import com.veight.user.model.enums.Gender;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author youyou
 */
@Entity
@Table(name = "TB_USER")
@Data
@NoArgsConstructor
public class UserModel extends UUIDEntity {

    /**
     * "用户名"Cookie名称
     */
    public static final String USERNAME_COOKIE_NAME = "username";

    private String username;

    private String password;

    @Column(nullable = false, updatable = false, unique = true, length = 100)
    @Pattern(regexp = "^[0-9a-z_A-Z\\u4e00-\\u9fa5]+$")
    private String name;

    @Column(unique = true)
    private String mobile;

    @Column(unique = true, nullable = true)
    private String idNumber;
    /**
     * E-mail
     */
    @Column(nullable = false)
    private String email;

    /**
     * 是否启用
     */
    @Column(nullable = false)
    private Boolean isEnabled = true;

    /**
     * 是否锁定
     */
    @Column(nullable = false)
    private Boolean isLock = false;

    /**
     * 连续登录失败次数
     */
    @Column(nullable = false)
    private Integer loginFailureCount = 0;

    /**
     * 锁定日期
     */
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockedDate;

    /**
     * 注册IP
     */
    @Column()
    private String registerIp;

    /**
     * 最后登录IP
     */
    private String loginIp;

    /**
     * 最后登录日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginDate;

    /**
     * 性别
     */
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.male;

    /**
     * 出生日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    public UserModel(String username,String name, String password, String email, String registerIp) {
        this.username=username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.registerIp = registerIp;
    }

    public UserModel(String username, String password, String name,  String mobile, String idNumber, String email, Date lockedDate, String registerIp, String loginIp, Date loginDate, Date birthday) {
        this.username = username;
        this.password = password;
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
