package com.prozenda.stepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Given;

public class FileUploadSteps {

    Pages pages = new Pages();

    @Given("user is on Login page")
    public void userIsOnLoginPage() {
        pages.getLoginPagePOM().navigate();
    }

    @Given("I login as: {string} with password: {string}")
    public void loginToMainPage(String email, String password) throws InterruptedException {
        pages.getTransactionsPagePOM().login(email, password);
    }

    @Given("Wait for loading main page")
    public void waitForMainPage() throws InterruptedException {
        pages.getTransactionsPagePOM().waitForLoadingMainPage();
    }
}
