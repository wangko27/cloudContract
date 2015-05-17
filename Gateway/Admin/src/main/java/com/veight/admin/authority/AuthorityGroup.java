/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.admin.authority;

import com.veight.common.security.enums.Authority;
import com.veight.common.security.enums.Realm;
import com.veight.common.BaseObject;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 权限组分配
 *
 * @author youyou
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityGroup extends BaseObject {

    private static final long serialVersionUID = 20140515L;

    @NotNull
    private Realm realm;

    @NotNull
    private String description;

    /**
     * 从Privilege获得所属的权限组
     *
     * @param privilege
     * @return
     */
    public static AuthorityGroup fromPrivilege(Authority authority) {
        return new AuthorityGroup(authority.getRealm(), authority.getDescription());
    }
}
