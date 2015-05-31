/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.market;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

/**
 *
 * @author youyou
 */
@ApplicationPath("/")
public class ResourceApplication extends ResourceConfig {

    public ResourceApplication() {
        packages("com.veight.market.resources");
        register(JspMvcFeature.class);
        register(JacksonFeature.class);
        register(MultiPartFeature.class);
    }
}
