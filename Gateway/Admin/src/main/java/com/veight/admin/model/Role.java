package com.veight.admin.model;

import com.veight.common.security.enums.Authority;
import com.veight.common.TimeScopeBaseObject;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
public class Role extends TimeScopeBaseObject {

    protected String id;
    /**
     * 获取名称
     *
     * @return 名称
     */
    private String name;

    /**
     * 获取是否内置
     *
     * @return 是否内置
     */
    private Boolean isSystem;

    /**
     * 获取描述
     *
     * @return 描述
     */
    private String description;

    /**
     * 获取权限
     *
     * @return 权限
     */
    private List<Authority> authorities;

    /**
     * 获取管理员
     *
     * @return 管理员
     */
    private Set<Admin> admins = new HashSet<Admin>();

    public Role(String name, Boolean isSystem, String description) {
        this.name = name;
        this.isSystem = isSystem;
        this.description = description;
    }

    public Role(String name, Boolean isSystem, String description, List<Authority> authorities) {
        this.name = name;
        this.isSystem = isSystem;
        this.description = description;
        this.authorities = authorities;
    }

    public Role(String id, String name, Boolean isSystem, String description, List<Authority> authorities) {
        this.id = id;
        this.name = name;
        this.isSystem = isSystem;
        this.description = description;
    }

}
