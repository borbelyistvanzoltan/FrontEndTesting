package com.prozenda.drivermanager;

import com.prozenda.utils.GetProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverProvider implements DriverProvider{

    public WebDriver getDriver() {
        String path = GetProperties.getProperty("geckodriver.path");
//        String path = "src/main/resources/webdrivers/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", path);

        return new FirefoxDriver();
    }
}
