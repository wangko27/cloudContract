/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.admin;

import com.veight.config.api.ConfigManager;
import com.veight.config.system.SystemConfig;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 * 应用程序的信息
 * @author youyou
 */
@Singleton
@Startup
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class ApplicationBean {

    @Inject
    Logger logger;

    @EJB
    ConfigManager configManager;

    private SystemConfig systemConfig;

    @PostConstruct
    public void init() {
        systemConfig = configManager.getSystemConfig();
        
        logger.debug("systemConfig DefaultPassword {}",systemConfig.getDefaultPassword());

    }

    //======================================================
    public SystemConfig getSystemConfig() {
        return systemConfig;
    }
    
    

}
