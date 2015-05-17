/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.common.security;

import com.veight.common.security.annotation.RequiresAuthorities;
import com.veight.common.security.annotation.RequiresGuest;
import com.veight.common.security.enums.Authority;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public abstract class AbstractShiroFilter implements ContainerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(AbstractShiroFilter.class);

    @Inject
    protected javax.inject.Provider<HttpServletRequest> request;

    @Inject
    protected javax.inject.Provider<ResourceInfo> resourceInfo;

    public AbstractShiroFilter() {

    }

    protected abstract boolean checkLogin();

    /**
     * Checks if the current subject has all required permissions.
     */
    protected abstract boolean checkPrivileges(final Authority... authorities);

    /**
     * If the user has sufficient permissions the request is executed. Otherwise
     * an exception is thrown which results in the HTTP status 403 (Forbidden).
     */
    @Override
    public void filter(ContainerRequestContext requestContext) {
        log.info("ShiroFilter  filter");
        //不需要登录
        if (resourceInfo.get().getResourceMethod().isAnnotationPresent(RequiresGuest.class)) {
            log.info("ShiroFilter  filter 不需要登录");
            return;
        }

        Set<Authority> authorities = new HashSet<>();

        final RequiresAuthorities resourceAuthorities = resourceInfo.get().getResourceClass().getAnnotation(RequiresAuthorities.class);
        final RequiresAuthorities methodAuthorities = resourceInfo.get().getResourceMethod().getAnnotation(RequiresAuthorities.class);

        if (resourceAuthorities != null && resourceAuthorities.value() != null && resourceAuthorities.value().length > 0) {
            authorities.addAll(Arrays.asList(resourceAuthorities.value()));
        }

        if (methodAuthorities != null && methodAuthorities.value() != null && methodAuthorities.value().length > 0) {
            authorities.addAll(Arrays.asList(methodAuthorities.value()));
        }

        Authority[] privileges = authorities.toArray(new Authority[authorities.size()]);
        boolean requiresGuest = privileges.length > 0
                || resourceInfo.get().getResourceClass().isAnnotationPresent(RequiresGuest.class)
                || resourceInfo.get().getResourceMethod().isAnnotationPresent(RequiresGuest.class);

        if (requiresGuest && !checkLogin()) {
            log.info("ShiroFilter  checkLogin not passed ");
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        if (privileges.length > 0 && !checkPrivileges(privileges)) {
            log.info("ShiroFilter  checkLogin not passed ");
            throw new WebApplicationException(privileges[0].getKey(), Response.Status.FORBIDDEN);
        }
    }

}
