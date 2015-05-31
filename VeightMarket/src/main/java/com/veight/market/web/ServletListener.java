/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.market.web;

import com.veight.cms.api.CategoryService;
import com.veight.cms.api.TagService;
import com.veight.cms.model.Category;
import com.veight.cms.model.Tag;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;

/**
 *
 * @author youyou
 */
@WebListener
public class ServletListener implements ServletContextListener, HttpSessionListener {

    @Inject
    Logger logger;

    @EJB
    CategoryService categoryService;

    @EJB
    TagService tagService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("ServletListener Starting...");
        //start
        ServletContext sc = sce.getServletContext();
        //放入系统信息
        sc.setAttribute("cloudSystemName", "云平台管理系统");

        List<Category> categories = categoryService.findAll();
        List<Tag> tags = tagService.findAll();
        
        sc.setAttribute("categories", categories);
        sc.setAttribute("tags", tags);
        //
        logger.info("ServletListener Started now");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

}
