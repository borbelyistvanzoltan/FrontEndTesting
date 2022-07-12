package com.prozenda.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {

    private GetProperties(){}

    public static String getProperty(String key) {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("src/main/resources/config/config.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(key);
    }
}
