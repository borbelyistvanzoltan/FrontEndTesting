package prozenda.stepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Given;

public class LoginPageSteps {

    Pages pages = new Pages();

    @Given("Open the Firefox and launch the application")
    public void open_the_Firefox_and_launch_the_application()
    {
        pages.getLoginPagePOM().navigate();
    }
}
