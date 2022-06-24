package com.prozenda.pages;


import com.prozenda.drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;

public class AbstractPage {

    public static WebDriver getDriver() {

        return DriverManager.getInstance().getDriver();
    }
}
