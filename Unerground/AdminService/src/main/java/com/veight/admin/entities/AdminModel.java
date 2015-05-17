package com.veight.admin.entities;

import com.veight.common.entities.UUIDEntity;
import com.veight.common.security.SecurityUtils;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity - 管理员
 *
 *
 *
 */
@Entity
@Table(name = "TB_ADMIN")
@Data
@NoArgsConstructor
public class AdminModel extends UUIDEntity {

    private static final long serialVersionUID = -7519486823153844426L;
    /**
     * 获取用户名
     *
     * @return 用户名
     */
    @NotEmpty
    @Length(min = 2, max = 20)
    @Column(nullable = false, updatable = false, unique = true, length = 100)
    private String username;

    /**
     * 获取密码
     *
     * @return 密码
     */
    @NotEmpty
    @Length(min = 4, max = 32)
    @Column(nullable = false)
    private String password;

    /**
     * salt value in hex
     */
    @Column(nullable = false, length = 120)
    protected String salt;
    /**
     * 获取E-mail
     *
     * @return E-mail
     */
    @NotEmpty
    @Email
    @Length(max = 200)
    @Column(nullable = false)
    private String email;

    /**
     * 姓名
     */
    @Length(max = 200)
    private String name;

    /**
     * 获取部门
     *
     * @return 部门
     */
    @Length(max = 200)
    private String department;

    /**
     * 获取是否启用
     *
     * @return 是否启用
     */
    @NotNull
    @Column(nullable = false)
    private Boolean isEnabled = true;

    /**
     * 是否锁定
     */
    @Column(nullable = false)
    private Boolean isLocked = false;

    /**
     * 获取连续登录失败次数
     *
     * @return 连续登录失败次数
     */
    @Column(nullable = false)
    private Integer loginFailureCount = 0;

    /**
     * 锁定日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockedDate;

    /**
     * 最后登录日期
     */
    @Temporal(TemporalType.TIMESTAMP)
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
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "TB_ADMIN_ROLE")
    private Set<RoleModel> roles;

    public AdminModel(String username, String password, String email, String name, String department, String loginIp) {
        this.username = username;
        this.password = password;
        this.salt = SecurityUtils.getSalt();
        this.email = email;
        this.name = name;
        this.department = department;
        this.loginIp = loginIp;
    }
    
    /**
     * 设置password对应的盐值和密文
     *
     * @param password
     */
    public void passphrase(final String password) {
        this.salt = SecurityUtils.getSalt();
        this.password = SecurityUtils.getPassphrase(salt, password);
    }

}
