package step_definitions.standard_user;

import io.cucumber.java.en.And;
import managers.Driver;
import org.testng.Assert;
import pages.standard_user.CheckoutPage;
import pages.standard_user.ProductsPage;

public class CheckoutSteps extends Driver {
    Driver driver;

    CheckoutPage checkoutPage;
    ProductsPage productsPage;

    public CheckoutSteps(Driver driver) {
        this.driver = driver;
    }

    @And("Select 'Continue Shopping'")
    public void clickContinueShopping() {
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.selectContinueShoppingButton();

    }

    @And("Proceed to checkout")
    public void clickOnCheckout() {
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.clickOnCheckoutButton();
    }

    @And("Click on 'Continue'")
    public void clickOnContinue() {
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.clickOnContinueButton();
    }

    @And("Click on 'Cancel' button to go back to {string} Page")
    public void clickOnCancel(String titlePageAssert){
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.clickOnCancelButton();
        Assert.assertTrue(checkoutPage.getPageTitleHeaderText().contains(titlePageAssert));
    }

    @And("Click on 'Continue Shopping' button to go back to {string} Page")
    public void clickOnContinueShopping(String titlePageAssert){
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.clickOnContinueShoppingButton();
        Assert.assertTrue(checkoutPage.getPageTitleHeaderText().contains(titlePageAssert));
    }


    @And("Insert the following data in the form: {string}, {string}, {string}")
    public void insertDataInTheForm(String firstName, String lastName, String postalCode){
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.insertValidData(firstName, lastName, postalCode);
    }

    @And("Insert data in the First Name and Postal Code fields: {string}, {string}")
    public void insertFirstNameAndPostalCode(String firstName, String postalCode){
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.insertInvalidDataLastNameMissing(firstName, postalCode);
    }

    @And("Insert data in the First Name and Last Name fields: {string}, {string}")
    public void insertDataInFirstNameAndLastName(String firstName, String lastName){
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.insertInvalidDataPostalCodeMissing(firstName, lastName);
    }

    @And("Insert data in the Last Name and Postal Code fields: {string}, {string}")
    public void insertDataInLastNameAndPostalCode(String lastName, String postalCode){
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.insertInvalidDataFirstNameMissing(lastName, postalCode);
    }

    @And("Click on 'Finish' and check the {string} order title message and {string} order description message")
    public void clickOnFinish(String titleAssert, String messageAssert){
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.clickOnFinishButton();
        Assert.assertTrue(checkoutPage.getCompleteOrderMessageTitle().contains(titleAssert));
        Assert.assertTrue(checkoutPage.getCompleteOrderMessageDescription().contains(messageAssert));
    }

    @And("Verify the name of the Page: {string} and the Green Tick image displayed")
    public void verifyTheNameAndImageCheckoutCompletePage(String titlePage){
        checkoutPage = new CheckoutPage(driver.getDriver());
        Assert.assertTrue(checkoutPage.getCompleteOrderImage());
        Assert.assertTrue(checkoutPage.getPageTitleHeaderText().contains(titlePage));

    }

    @And("Click on 'Back Home' and verify that the user is on {string} Page")
    public void clickOnBackHome(String titlePageAssert){
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.clickOnBackHomeButton();
        Assert.assertTrue(checkoutPage.getPageTitleHeaderText().contains(titlePageAssert));
    }

    @And("Verify the Summary Info: {string}, {string}, {string}, {string}, {string} are present")
    public void verifySummaryInfo(String paymentInformationLabel, String shippingInformationLabel, String subtotalValue, String taxValue, String finalTotal){
        checkoutPage = new CheckoutPage(driver.getDriver());
        Assert.assertTrue(checkoutPage.getSummaryInfoText().contains(paymentInformationLabel));
        Assert.assertTrue(checkoutPage.getSummaryInfoText().contains(shippingInformationLabel));
        Assert.assertTrue(checkoutPage.getSubtotalText().contains(subtotalValue));
        Assert.assertTrue(checkoutPage.getTaxText().contains(taxValue));
        Assert.assertTrue(checkoutPage.getFinalTotalText().contains(finalTotal));
    }

    @And("Verify the Items information in the Checkout Overview: {string}, {string}, {string}, {string} are present")
    public void verifyCartListInfo(String quantityItem, String itemTitle, String descriptionItem, String inventoryPrice){
        checkoutPage = new CheckoutPage(driver.getDriver());
        Assert.assertTrue(checkoutPage.getQuantityItemInfoText().contains(quantityItem));
        Assert.assertTrue(checkoutPage.getItemTitleCartInfo().contains(itemTitle));
        Assert.assertTrue(checkoutPage.getItemDescriptionInfoText().contains(descriptionItem));
        Assert.assertTrue(checkoutPage.getInventoryItemPrice().contains(inventoryPrice));
    }

    @And("Verify that the {string} error message is displayed")
    public void checkErrorMessage(String errorText){
        checkoutPage = new CheckoutPage(driver.getDriver());
        Assert.assertTrue(checkoutPage.getTheErrorMessageText().contains(errorText));
    }

    @And("Click on 'Remove' button")
    public void clickOnRemove(){
        checkoutPage = new CheckoutPage(driver.getDriver());
        checkoutPage.clickOnRemoveButton();
    }



}
