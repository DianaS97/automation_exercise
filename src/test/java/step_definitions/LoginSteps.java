package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import managers.Driver;
import org.testng.Assert;
import pages.LoginPage;
import pages.standard_user.CheckoutPage;
import utils.ConfigurationReader;

public class LoginSteps extends Driver {

    Driver driver;
    LoginPage loginPage;

    CheckoutPage checkoutPage;

    public LoginSteps(Driver driver) {
        this.driver = driver;
    }

    @Given("Open Secret Sauce")
    public void openSecretSauce() {
        driver.startSecretSauce();
    }

    @And("Login as a standard_user")
    public void loginAsAStandardUser() {

        final ConfigurationReader configurationReader = new ConfigurationReader();

        loginPage = new LoginPage(driver.getDriver());
        loginPage.loginStandardUser(configurationReader.getStandardUser(), configurationReader.getPassword());
    }

    @And("Login as a locked_out_user")
    public void loginAsALockedOutUser() {

        final ConfigurationReader configurationReader = new ConfigurationReader();

        loginPage = new LoginPage(driver.getDriver());
        loginPage.loginLockedOutUser(configurationReader.getLockedOutUser(), configurationReader.getPassword());
    }

    @And("Login as a problem_user")
    public void loginAsAProblemUser() {

        final ConfigurationReader configurationReader = new ConfigurationReader();

        loginPage = new LoginPage(driver.getDriver());
        loginPage.loginProblemUser(configurationReader.getProblemUser(), configurationReader.getPassword());
    }

    @And("Login as a performance_glitch_user")
    public void loginAsAPerformanceGlitchUser() {

        final ConfigurationReader configurationReader = new ConfigurationReader();

        loginPage = new LoginPage(driver.getDriver());
        loginPage.loginPerformanceGlitchUser(configurationReader.getPerformanceGlitchUser(), configurationReader.getPassword());
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
