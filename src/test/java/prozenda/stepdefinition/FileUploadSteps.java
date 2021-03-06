package prozenda.stepdefinition;

import com.prozenda.pages.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

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

    @Then("Navigate to Import file page")
    public void navigateToImportFilePage() throws InterruptedException {
        pages.getTransactionsPagePOM().navigateToFileUploadsPage();
    }

    @Then("Upload transaction file from")
    public void uploadTransactionFile() throws InterruptedException {
        pages.getTransactionsPagePOM().uploadTransactionFile();
    }

    @Then("Commit {string}")
    public void commitTransaction(String transactionNumber) throws InterruptedException {
        pages.getTransactionsPagePOM().commitTransaction(transactionNumber);
    }

    @Then("Navigate to Bookings page")
    public void navigatesToBookingsPage() throws InterruptedException {
        pages.getTransactionsPagePOM().navigatesToBookings();
    }

    @Then("Check {string} transaction committed")
    public void checkTransactionCommitted(String transactionNumber) throws InterruptedException {
        pages.getTransactionsPagePOM().checkParameterElementIsExist(transactionNumber);
    }

    @Then("Check {string} transaction committed from Buyer side")
    public void checkTransactionCommittedFromBuyerSide(String transactionNumber) throws InterruptedException {
        pages.getTransactionsPagePOM().checkParameterElementIsExistFromBuyerSide(transactionNumber);
    }

    @Then("Change dropdown and select Seller - All Due")
    public void selectDropDownAndCheckTableFromSellerSide() {
        pages.getTransactionsPagePOM().changeQuickViewToSellerAllDue();
    }

    @Then("Change dropdown and select Buyer - All Due")
    public void selectDropDownAndCheckTableFromBuyerSide() {
        pages.getTransactionsPagePOM().changeQuickViewToBuyerAllDue();
    }

    @Then("Logout")
    public void logout() {
        pages.getTransactionsPagePOM().logout();
    }
}
