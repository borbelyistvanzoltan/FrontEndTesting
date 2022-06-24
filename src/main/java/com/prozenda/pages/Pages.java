package com.prozenda.pages;

public class Pages {

    private LoginPagePOM loginPagePOM;

    public LoginPagePOM getLoginPagePOM(){
        if ( loginPagePOM == null ){
            loginPagePOM = new LoginPagePOM();
        }
        return loginPagePOM;
    }
}
