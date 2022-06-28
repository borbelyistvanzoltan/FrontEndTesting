package com.prozenda.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TransactionsPagePOM extends AbstractPage {

    private static By loginBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div/div[1]/main/div/form/button");
    private static By fileUploadsBtnInMenu = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[2]/div/div/a[3]/span[1]");
    private static By uploadFileBtnInSubMenu = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div[1]/button[1]/span[1]");
    private static By dropFileBtn = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[1]/div");
    private static By inputType = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[1]/div/input");
    private static By uploadBtn = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[4]/div[2]/button");
    private static By importCheckBox = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[4]/label/span[1]/span[1]/input");
    private static By uploadBtnAgain = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[5]/div[2]/button");
    private static By alertMessageAfterUpload = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[4]/div/div");
    private static By bookingRefernceFilterFieldFromBuyer = By.xpath("//table[1]/thead/tr[2]/th[5]/div/div/input");
    private static By bookingRefernceFilterFieldAfterUpload = By.xpath("//table[1]/thead/tr[2]/th[10]/div/div/input");
    private static By checkBoxAfterUploadFromBuyer = By.xpath("//table[2]/tbody/tr/td[1]/span/span/input");
    private static By bookingRefernceFilterFieldFromSeller = By.xpath("//table[1]/thead/tr[2]/th[6]/div/div/input");
    private static By updatePartnerBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div[3]/div[1]/div/span[2]/button/span[1]");
    //By partnerName = By.id("mui-66753");
    //*[@id="mui-67676"]
    private static By commercialLinkField = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[1]/div[2]/div/div/div");
    private static By prozendaTestAutomationCommercialLink = By.xpath("/html/body/div[5]/div[3]/ul/li");
    private static By commercialLinkSelectionOkBtn = By.xpath("/html/body/div[4]/div[3]/div/div/div/div[2]/div[2]/button");
    private static By commitBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div[3]/div[1]/div/span[1]/button/span[1]");
    private static By bookingsBtnInMenu = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[2]/div/div/a[1]");
    private static By resetFiltersBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div/div/div[1]/button[1]/span[1]");
    private static By logoutBtn = By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/ul[2]/div/div[2]/span");
    private static By quickViewDropDown = By.xpath("/html/body/div[1]/div[2]/div[1]/main/div[3]/div/div/div/div[1]/h6/div/label/div/div");
    private static By sellerAllDueOption = By.xpath("/html/body/div[4]/div[3]/ul/li[5]");
    private static By buyerAllDueOption = By.xpath("/html/body/div[4]/div[3]/ul/li[2]");
    private static By tableColumnReferenceSeller = By.xpath("//table[2]/tbody/tr/td[6]");
    private static By tableColumnReferenceBuyer = By.xpath("//table[2]/tbody/tr/td[5]");
    private static By txStatusDropDown = By.xpath("//table[2]/tbody/tr[1]/td[13]/div/div");
    private static By txStatusDropDownValues = By.xpath("//table[2]/tbody/tr[1]/td[13]/div/div[2]/div[3]/ul");
    private static By txAccepted = By.xpath("//table[2]/tbody/tr[1]/td[13]/div");
    private static By txRejected = By.xpath("//table[2]/tbody/tr[4]/td[11]/div/div[2]/div[3]/ul/li[3]");
    // Accepted: table[2]/tbody/tr[4]/td[11]/div/div[2]/div[3]/ul/li[1]
    // Rejected: table[2]/tbody/tr[4]/td[11]/div/div[2]/div[3]/ul/li[3]
    private static By reasonCodeCancelledBooking = By.xpath("//table[2]/tbody/tr[9]/td[12]/div/div[2]/div[3]/ul/li[5]");
    private static By currentAm = By.xpath("//table[2]/tbody/tr[1]/td[12]/div/div");
    private static By emailInput = By.id("email");
    private static By passwordInput = By.id("password");

    WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(6));

    Actions action = new Actions(getDriver());

    public void login(String email, String pass) throws InterruptedException {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(emailInput), Duration.ofSeconds(5) );
        getDriver().findElement(emailInput).sendKeys(email);
        getDriver().findElement(passwordInput).sendKeys(pass);
        getDriver().findElement(loginBtn).click();
        waitForLoadingMainPage();
    }

    public By getFileUploadsBtnInMenu() {
        return fileUploadsBtnInMenu;
    }

    public void navigateToFileUploadsPage() throws InterruptedException {
        getDriver().findElement(fileUploadsBtnInMenu).click();
        Thread.sleep(1000);
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getCheckBoxBtnPath()));
    }

    public void checkParameterElementIsExist(String transactionNumber) throws InterruptedException {
        filterBookingReferenceFromSellerSide(transactionNumber);
        List<WebElement> col = getDriver().findElements(tableColumnReferenceSeller);
        assertTrue(col.stream().anyMatch((element) -> element.getText().contains(transactionNumber)));
        System.out.println(transactionNumber + " transaction appear in Bookings page from Seller side!");
    }

    public void checkParameterElementIsExistFromBuyerSide(String transactionNumber) throws InterruptedException {
        filterBookingReference(transactionNumber);
        List<WebElement> col = getDriver().findElements(tableColumnReferenceBuyer);
        assertTrue(col.stream().anyMatch((element) -> element.getText().contains(transactionNumber)));
        System.out.println(transactionNumber + " transaction appear in Bookings page from Buyer side!");
    }

    public void changeQuickViewToSellerAllDue() {
        getDriver().findElement(quickViewDropDown).click();
        getDriver().findElement(sellerAllDueOption).click();
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(sellerAllDueOption)).click();
    }

    public void changeQuickViewToBuyerAllDue() {
        getDriver().findElement(quickViewDropDown).click();
        getDriver().findElement(buyerAllDueOption).click();
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(sellerAllDueOption)).click();
    }

    //Method to upload file
    public void uploadTransactionFile() throws InterruptedException {
        String location = "/Users/borbelyistvan/Documents/Prozenda/Travelledger/Prozenda.txt";
        System.out.println("Click upload file in sub menu.");
        getDriver().findElement(uploadFileBtnInSubMenu).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(dropFileBtn));
        System.out.println("Upload file button in sub menu clicked and drop file button loaded.");
        WebElement uploadElement = getDriver().findElement(inputType);
        uploadElement.sendKeys(location);

        System.out.println("Transaction file selected lets click upload button.");
        Thread.sleep(3000);
        getDriver().findElement(uploadBtn).click();
        System.out.println("Upload button clicked lets click check box.");
        Thread.sleep(3000);
        getDriver().findElement(importCheckBox).click();
        Thread.sleep(3000);
        getDriver().findElement(uploadBtnAgain).click();
        Thread.sleep(3000);
    }

    public void commitTransaction(String transactionNumber) throws InterruptedException {
        filterBookingReferenceAfterFileUpload(transactionNumber);
        System.out.println("Filter the transaction number.");
        Thread.sleep(2000);
        getDriver().findElement(checkBoxAfterUploadFromBuyer).click();
        System.out.println("Checkbox selected after commetting transaction.");
        Thread.sleep(2000);
        getDriver().findElement(updatePartnerBtn).click();
        System.out.println("Update button clicked.");
        Thread.sleep(15000);

        //TODO: manually step: type Prozenda2 into text box.

        //findElement(By.xpath("//*[contains(@id,'mui')]")).click();
        System.out.println("Partnername is Prozenda2 set by manually.");
        Thread.sleep(1000);
        getDriver().findElement(commercialLinkField).click();
        Thread.sleep(1000);
        getDriver().findElement(prozendaTestAutomationCommercialLink).click();
        System.out.println("Commercial link is Prozenda Test automation.");
        Thread.sleep(1000);
        getDriver().findElement(commercialLinkSelectionOkBtn).click();
        Thread.sleep(5000);
        System.out.println("Wait to disappear message.");

        getDriver().findElement(bookingsBtnInMenu).click();
        System.out.println("Go to Bookings page.");
        Thread.sleep(2000);

        getDriver().findElement(fileUploadsBtnInMenu).click();
        System.out.println("Go to back to File uploads page.");
        Thread.sleep(2000);

        filterBookingReferenceAfterFileUpload(transactionNumber);
        System.out.println("Filter the transaction number.");

        getDriver().findElement(checkBoxAfterUploadFromBuyer).click();
        System.out.println("Checkbox selected.");
        Thread.sleep(2000);

        getDriver().findElement(commitBtn).click();
        System.out.println("Commit button clicked.");
        Thread.sleep(2000);



    }


    //Method to navigate Bookings
    public void navigatesToBookings () throws InterruptedException {
        //webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(alertMessageAfterUpload));
        Thread.sleep(15000);
        getDriver().findElement(bookingsBtnInMenu).click();
        Thread.sleep(1000);
    }

    //Method to check transactions
    public void checkCommitedTransactions () throws InterruptedException {
        //TODO
        Thread.sleep(3000);
    }

    //Method to logout
    public void logout() {
        getDriver().findElement(logoutBtn).click();
        //quit();
    }

    // Given a transaction number and return the number of the row which contains the transaction
    public int whichNumberOfTheRow(String transactionNumber) {
        /*
        // identify table
        WebElement myTable = findElement(By.xpath("//table/tbody"));
        //identify rows of table.
        List<WebElement> l = myTable.findElements(By.tagName("tr"));

        String b_xpath = "//table[2]/tbody/tr[";
        String a_xpath = "]/td[5]";

        int i;
        for (i = 1; i <= l.size(); i++) {
            String n = findElement(By.xpath(b_xpath + i + a_xpath)).getText();
            if (n.contains(transactionNumber)) {
                // get text of matching cell
                String celtxt = findElement(By.xpath("//table[2]/tbody/tr[" + i + "]/td[5]")).getText();
                System.out.println("The transaction " + celtxt + " is in " + i + " row.");
                return i;
            }
        }
        return i;

         */
        return 1;
    }

    //Method to click on blank status transaction and change to Accepted
    public void clickOnBlankStatusFieldAndSelectAcceptedStatus(String transactionNumber) throws InterruptedException {
        getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).click();
//        log.println("Checkbox clicked.");
        getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div")).click();
//        log.println("ACCEPTED selected.");
        assertTrue(getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("ACCEPTED"));
//        log.println("ACCEPTED checked and it success.");

        Thread.sleep(2000);
        getDriver().findElement(fileUploadsBtnInMenu).click();
//        log.println("Navigate to another page.");
        Thread.sleep(2000);

        getDriver().findElement(bookingsBtnInMenu).click();
//        log.println("Navigate back to Booking page.");
        Thread.sleep(2000);

        getDriver().findElement(quickViewDropDown).click();
        getDriver().findElement(buyerAllDueOption).click();
        Thread.sleep(2000);

        filterBookingReference(transactionNumber);
        Thread.sleep(2000);

        assertTrue(getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("ACCEPTED"));
        Thread.sleep(2000);
//        log.println("ACCEPTED checked and it success.");
    }

    //Method to click on blank status transaction and change to Rejected
    public void clickOnBlankStatusFieldAndSelectRejectedStatus(String transactionNumber) throws InterruptedException {
        getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).click();
//        log.println("Checkbox clicked.");
        getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div[2]/div[3]/ul/li[3]")).click();

        getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[14]/div/div[2]/div[3]/ul/li[5]")).click();

//        log.println("REJECTED selected.");
        assertTrue(getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("REJECTED"));
//        log.println("REJECTED checked and it success.");

        Thread.sleep(2000);
        getDriver().findElement(fileUploadsBtnInMenu).click();
//        log.println("Navigate to another page.");
        Thread.sleep(2000);

        getDriver().findElement(bookingsBtnInMenu).click();
//        log.println("Navigate back to Booking page.");
        Thread.sleep(2000);

        getDriver().findElement(quickViewDropDown).click();
        getDriver().findElement(buyerAllDueOption).click();
        Thread.sleep(2000);

        filterBookingReference(transactionNumber);
        Thread.sleep(2000);

        assertTrue(getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("REJECTED"));
        Thread.sleep(2000);
//        log.println("REJECTED checked and it success.");
    }

    //Method to click on blank status transaction and change to Rejected
    public void clickOnBlankStatusFieldAndSelectAmendedStatus(String transactionNumber) throws InterruptedException {
        Thread.sleep(4000);
        getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[12]/div/div/input")).sendKeys("200");
//        log.println("Set amount to 200");
        Thread.sleep(4000);
        getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).click();
//        log.println("Checkbox clicked.");
        Thread.sleep(4000);

        getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[14]/div/div[2]/div[3]/ul/li[5]")).click();
        //table[2]/tbody/tr[12]/td[12]/div/div[2]/div[3]/ul/li[5]
        //table[2]/tbody/tr/td[14]/div/div[2]/div[3]/ul/li[5]
        Thread.sleep(4000);
//        log.println("AMENDED selected, reason code set.");




        assertTrue(getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("AMENDED"));
//        log.println("AMENDED checked and it success.");

        Thread.sleep(2000);
        getDriver().findElement(fileUploadsBtnInMenu).click();
//        log.println("Navigate to another page.");
        Thread.sleep(2000);

        getDriver().findElement(bookingsBtnInMenu).click();
//        log.println("Navigate back to Booking page.");
        Thread.sleep(2000);

        getDriver().findElement(quickViewDropDown).click();
        getDriver().findElement(buyerAllDueOption).click();
        Thread.sleep(2000);

        filterBookingReference(transactionNumber);
        Thread.sleep(2000);

        assertTrue(getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).getText().equals("AMENDED"));
        Thread.sleep(2000);
//        log.println("AMENDED checked and it success.");
    }

    // Validating Tx Status dropdown elements
    public void isFoundAllOptions(String transactionNumber) throws InterruptedException {
        System.out.println(whichNumberOfTheRow(transactionNumber));
        getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div")).click();
        System.out.println("Clicked the dropbox");
        WebElement status = getDriver().findElement(By.xpath("//table[2]/tbody/tr[" + whichNumberOfTheRow(transactionNumber) + "]/td[13]/div/div[2]/div[3]/ul"));
        List<WebElement> links = status.findElements(By.tagName("li"));
        for (int i = 0; i < links.size(); i++) {
            assertTrue(links.get(i).getText().equals("ACCEPTED") || links.get(i).getText().equals("AMENDED") || links.get(i).getText().equals("REJECTED"));
        }
        System.out.println("Assertation of ACCEPTED, AMENDED, REJECTED Tx status are passed.");
        action.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(2000);
    }

    public void filterBookingReference(String transactionNumber) throws InterruptedException {
        getDriver().findElement(bookingRefernceFilterFieldFromBuyer).sendKeys(transactionNumber);
        Thread.sleep(2000);
    }

    public void filterBookingReferenceAfterFileUpload(String transactionNumber) throws InterruptedException {
        getDriver().findElement(bookingRefernceFilterFieldAfterUpload).sendKeys(transactionNumber);
        Thread.sleep(2000);
    }

    public void filterBookingReferenceFromSellerSide(String transactionNumber) throws InterruptedException {
        getDriver().findElement(bookingRefernceFilterFieldFromSeller).sendKeys(transactionNumber);
        Thread.sleep(4000);
    }

    public void waitForLoadingMainPage() throws InterruptedException {
        // 15 sec sleep for 2FA
        Thread.sleep(15000);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getFileUploadsBtnInMenu()));
    }


}
