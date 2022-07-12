package com.prozenda.drivermanager;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static DriverManager instance;
    private static DriverProvider driverProvider;
    private static WebDriver webDriver;

    private DriverManager() {}

    public static DriverManager getInstance() {
        if (instance == null) {
            driverProvider = new FirefoxDriverProvider();
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (webDriver == null) {
            webDriver = driverProvider.getDriver();
        }
        return webDriver;
    }


    public void closeDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    public static boolean isDriverOpen() {
        return instance != null;
    }
}
