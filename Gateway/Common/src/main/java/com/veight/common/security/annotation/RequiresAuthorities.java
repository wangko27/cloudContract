/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common.security.annotation;

import com.veight.common.security.enums.Authority;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要相应的权限才可以访问该资源
 *
 * @author youyou
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresAuthorities {

    /**
     * The permission string which will be passed to
     * {@link org.apache.shiro.subject.Subject#isPermitted(String)} to determine
     * if the user is allowed to invoke the code protected by this annotation.
     */
    Authority[] value();

    /**
     * The logical operation for the permission checks in case multiple roles
     * are specified. AND is the default
     *
     * @since 1.1.0
     */
    Logical logical() default Logical.AND;
}
