package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import managers.Driver;

import org.junit.Assert;
import pages.LoginPage;
import pages.standard_user.CheckoutPage;

public class LoginSteps {

    Driver driver;
    LoginPage loginPage;

    CheckoutPage checkoutPage;

    public LoginSteps(Driver driver) {
        this.driver = driver;
    }

    @Given("Open Secret Sauce in {string} browser")
    public void openSecretSauce(String browser) {
        driver.startSecretSauce(browser);

    }

    @And("Login as a {string} user using {string} password")
    public void login(String userType, String password) {
        loginPage = new LoginPage(driver.getDriver());
        loginPage.loginAs(userType, password);
    }

    @Then("Click on the 'Login' button")
    public void clickOnLoginButton() {
        loginPage = new LoginPage(driver.getDriver());
        loginPage.clickLogin();
    }

    @Then("Verify that the user is on {string} Page")
    public void verifyTheHeaderPage(String titlePageAssert) {
        checkoutPage = new CheckoutPage(driver.getDriver());
        Assert.assertTrue(checkoutPage.getPageTitleHeaderText().contains(titlePageAssert));
    }

    @Then("Verify that the error message is displayed")
    public void verifyTheErrorMessage() {
        loginPage = new LoginPage(driver.getDriver());
        Assert.assertTrue(loginPage.getLockedOutErrorMessage().contains("Epic sadface: Sorry, this user has been locked out."));
    }

}
