package org.java.dev.properties;

import org.java.dev.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyService {
    private static final String PROPERTIES_FILE_NAME = "application.properties";
    public static String getProperty(Constant constant) {
        Properties properties = new Properties();
        try {
            properties.load(PropertyService.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(constant.getPropertyName());
    }
}
