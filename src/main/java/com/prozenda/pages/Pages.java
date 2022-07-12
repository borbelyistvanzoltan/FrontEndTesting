package com.prozenda.pages;

public class Pages {

    private LoginPagePOM loginPagePOM;
    private TransactionsPagePOM transactionsPagePOM;

    public LoginPagePOM getLoginPagePOM(){
        if ( loginPagePOM == null ){
            loginPagePOM = new LoginPagePOM();
        }
        return loginPagePOM;
    }

    public TransactionsPagePOM getTransactionsPagePOM() {
        if ( transactionsPagePOM == null ){
            transactionsPagePOM = new TransactionsPagePOM();
        }
        return transactionsPagePOM;
    }
}
