package org.balartinc.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    public static Properties readConfigProperties(String fileName) throws Exception {
        fileName.trim();
        Properties configProperties = new Properties();
        InputStream inputStream = new FileInputStream(fileName);
        configProperties.load(inputStream);
        return configProperties;
    }
}
