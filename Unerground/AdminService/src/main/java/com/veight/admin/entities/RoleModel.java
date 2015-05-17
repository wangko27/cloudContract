package com.veight.admin.entities;

import com.veight.common.entities.UUIDEntity;
import com.veight.common.security.enums.Authority;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity - 角色
 *
 *
 *
 */
@Entity
@Table(name = "TB_ROLE")
@Data
@NoArgsConstructor
public class RoleModel extends UUIDEntity {

    private static final long serialVersionUID = -6614052029623997372L;

    /**
     * 获取名称
     *
     * @return 名称
     */
    @NotEmpty
    @Length(max = 200)
    @Column(nullable = false)
    private String name;

    /**
     * 获取是否内置
     *
     * @return 是否内置
     */
    @Column(nullable = false, updatable = false)
    private Boolean isSystem;

    /**
     * 获取描述
     *
     * @return 描述
     */
    @Length(max = 200)
    private String description;

    /**
     * 获取权限
     *
     * @return 权限
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TB_ROLE_AUTHORITY")
    @Enumerated(EnumType.STRING)
    private List<Authority> authorities;

    /**
     * 获取管理员
     *
     * @return 管理员
     */
//    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER,cascade = { CascadeType.ALL })
//    private Set<AdminModel> admins;
    public RoleModel(String name, Boolean isSystem, String description, List<Authority> authorities) {
        this.name = name;
        this.isSystem = isSystem;
        this.description = description;
        this.authorities = authorities;
    }
}
