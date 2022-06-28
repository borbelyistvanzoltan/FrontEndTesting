package com.prozenda;

import com.prozenda.drivermanager.DriverManager;
import org.openqa.selenium.WebDriver;
import com.prozenda.pages.LoginPagePOM;

import java.util.concurrent.TimeUnit;

public class Bench {

    public static Bench bench;
    private WebDriver webDriver;
    private LoginPagePOM loginPagePOM;
    private static final int TIMEOUT = 10;

    public Bench() {
        this.bench = this;
    }

    public void openBrowserTest() {
        loginPagePOM = new LoginPagePOM();
        webDriver = DriverManager.getInstance().getDriver();
        webDriver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().window().fullscreen();
    }

    public void closeTest() {
        if(webDriver != null) {
            DriverManager.getInstance().closeDriver();
        }
    }

//    public LoginPagePOM getLoginPagePOM() {
//        loginPagePOM.navigate();
//
//        return loginPagePOM;
//    }
}
