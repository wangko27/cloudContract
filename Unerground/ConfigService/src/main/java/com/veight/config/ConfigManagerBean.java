/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.config;

import com.veight.config.api.ConfigManager;
import com.veight.config.system.SystemConfig;
import java.io.IOException;
import java.io.Reader;
import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.slf4j.Logger;

/**
 *
 * @author youyou
 */
@Remote
@Startup
@Singleton
public class ConfigManagerBean implements ConfigManager {

    @Inject
    Logger logger;
    @Inject
    ConfigLoader loader;

    private JAXBContext context;

    private Unmarshaller unmarshaller;

    @PostConstruct
    void init() {
        logger.info("Load Config init ....");
        try {
            this.context = JAXBContext.newInstance(new Class[]{UpYunConfig.class, SystemConfig.class});
            this.unmarshaller = this.context.createUnmarshaller();
        } catch (Exception ex) {
            this.logger.error("Error init JAXB env", ex);
        }
    }

    private BaseConfig loadConfig(Class clazz) {
        BaseConfig result = null;
        String className = clazz.getName();
        try {
            String configName = (String) clazz.getField("CONFIG_NAME").get(null);
            try {
                Reader reader = this.loader.loadConfig(configName);
                Throwable localThrowable2 = null;
                try {
                    result = (BaseConfig) this.unmarshaller.unmarshal(reader);
                    result.setLastUpdate(System.currentTimeMillis());
                    result.setLastModified(this.loader.getLastModified(configName));
                } catch (Throwable localThrowable1) {
                    localThrowable2 = localThrowable1;
                    throw localThrowable1;
                } finally {
                    if (reader != null) {
                        if (localThrowable2 != null) {
                            try {
                                reader.close();
                            } catch (Throwable x2) {
                                localThrowable2.addSuppressed(x2);
                            }
                        } else {
                            reader.close();
                        }
                    }
                }
            } catch (IOException ex) {
                this.logger.error("Cannot get Reader for " + className, ex);
            } catch (JAXBException ex) {
                this.logger.error("Cannot unmarshall the " + className + ", check config content.", ex);
            }
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {
            this.logger.error("Config class " + className + " may not have CONFIG_NAME as public static field.", ex);
        }
        return result;
    }

    /**
     * upyun
     *
     * @return
     */
    @Override
    public UpYunConfig getUpYunConfig() {
        return (UpYunConfig) loadConfig(UpYunConfig.class);
    }

    /**
     * 系统配置
     *
     * @return
     */
    @Override
    public SystemConfig getSystemConfig() {
        return (SystemConfig) loadConfig(SystemConfig.class);
    }
}
