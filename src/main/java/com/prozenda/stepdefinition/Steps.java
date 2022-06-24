package com.prozenda.stepdefinition;

import com.prozenda.Bench;
import com.prozenda.pages.Pages;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class Steps {

    private static Bench bench;
    private Pages pages = new Pages();

    @BeforeAll
    public static void setup() {
        if(Bench.bench == null) {
            new Bench();
        }
        bench = Bench.bench;
        bench.openBrowserTest();
    }

    @AfterAll
    public static void tearDown() {
        bench.closeTest();
        bench = null;
    }

    @Given("^Open the Firefox and launch the application$")
    public void open_the_Firefox_and_launch_the_application()
    {
        pages.getLoginPagePOM().navigate();
    }
}
