/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.config.impl;

import com.veight.config.ConfigLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author youyou
 */
@Local
@ApplicationScoped
public class LocalConfigLoader implements ConfigLoader {

    private static final String DEFAULT_CONFIG_DIR = "/var/Veight/config/";

    @Override
    public Reader loadConfig(String configName) throws IOException {
        String configFileName = getConfigFilename(configName);
        File configFile = new File(configFileName);
        if ((configFile.exists()) && (configFile.canRead())) {
            return new FileReader(configFile);
        }
        throw new FileNotFoundException(configFileName);
    }

    @Override
    public long getLastModified(String configName) {
        String configFileName = getConfigFilename(configName);
        File configFile = new File(configFileName);
        if ((configFile.exists()) && (configFile.canRead())) {
            return configFile.lastModified();
        }
        return -1L;
    }

    private String getConfigFilename(String configName) {
        return DEFAULT_CONFIG_DIR + configName + ".xml";
    }
}
