/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common.security.enums;

import com.veight.common.enums.BaseEnum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 权限集合
 *
 * @author youyou
 *
 */
public enum Authority implements BaseEnum {

    ADMIN_DASHBOARD("admin:dashboard", "显示后台首页", Realm.USER, "用户相关权限"),
    /**
     * 用户相关权限
     */
    ADMIN_LIST("admin:list", "列出用户", Realm.USER, "用户相关权限"),
    ADMIN_DETAIL("admin:detail", "查看用户详情", Realm.USER, "用户相关权限"),
    ADMIN_ALTER("admin:alter", "添加更改用户信息", Realm.USER, "用户相关权限"),
    ADMIN_DISABLE("admin:disable", "禁用用户", Realm.USER, "用户相关权限"),
    ADMIN_DOWNLOAD("admin:download", "下载用户信息", Realm.USER, "用户相关权限"),
    ADMIN_RESETPASSWORD("admin:resetpassword", "重置用户密码", Realm.USER, "用户相关权限"),
    
    ROLE_LIST("role:list", "列出角色", Realm.ROLE, "角色相关权限"),
    ROLE_DETAIL("role:detail", "查看角色详情", Realm.ROLE, "角色相关权限"),
    ROLE_ALTER("role:alter", "添加更改角色信息", Realm.ROLE, "角色相关权限");

    private final String key;
    private final String name;
    private final Realm realm;

    private final String description;

    /**
     * realm所属的所有priviledges
     */
    private static final Map<Realm, List<Authority>> realm2Privilege = new HashMap<>();

    static {
        for (Authority privilege : Authority.values()) {
            List<Authority> privilegeList = realm2Privilege.get(privilege.getRealm());
            if (privilegeList == null) {
                privilegeList = new ArrayList<>();
                privilegeList.add(privilege);
                realm2Privilege.put(privilege.getRealm(), privilegeList);
            } else {
                realm2Privilege.get(privilege.getRealm()).add(privilege);
            }
        }
    }

    Authority(String key, String name, Realm realm, String description) {
        this.key = key;
        this.name = name;
        this.realm = realm;
        this.description = description;
    }

    @Override
    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public Realm getRealm() {
        return realm;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 获得realm所有对应的priviledge
     *
     * @param realm
     * @return
     */
    public static List<Authority> listByIncludedRealm(Realm... realms) {
        if (realms == null || realms.length == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Authority> result = new ArrayList<>();
        for (Realm realm : realms) {
            List<Authority> temp = realm2Privilege.get(realm);
            if (temp != null && !temp.isEmpty()) {
                result.addAll(temp);
            }
        }
        return result;
    }

    /**
     * 列出所有不属于realm的priviledge,主要给不同的客户权限管理显示不同的可用权限列表
     *
     * @param realms
     * @return
     */
    public static List<Authority> listByExcludedRealm(Realm... realms) {
        List<Authority> result = new ArrayList<>();
        Set excludedRealms = new HashSet(Arrays.asList(realms));
        for (Realm realm : realm2Privilege.keySet()) {
            if (!excludedRealms.contains(realm)) {
                List<Authority> temp = realm2Privilege.get(realm);
                if (temp != null && !temp.isEmpty()) {
                    result.addAll(temp);
                }
            }
        }
        return result;
    }
}
