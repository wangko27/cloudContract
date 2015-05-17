/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.config.api;

import com.veight.config.UpYunConfig;
import com.veight.config.system.SystemConfig;
import javax.ejb.Remote;

/**
 *
 * @author sobranie
 */
@Remote
public interface ConfigManager {

    public UpYunConfig getUpYunConfig();

    public SystemConfig getSystemConfig();
}
