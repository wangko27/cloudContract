/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veight.config;

import java.io.IOException;
import java.io.Reader;

public abstract interface ConfigLoader {

    public abstract Reader loadConfig(String paramString)
            throws IOException;

    public abstract long getLastModified(String paramString);
}