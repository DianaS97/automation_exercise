package step_definitions.standard_user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import managers.Driver;
import org.testng.Assert;
import pages.standard_user.ProductsPage;

public class ProductsPageSteps extends Driver {

    Driver driver;
    ProductsPage productsPage;


    public ProductsPageSteps(Driver driver) {
        this.driver = driver;
    }

    @And("Sort the items by {string}")
    public void sortTheItems(String value) {
        productsPage = new ProductsPage(driver.getDriver());
        productsPage.selectTheSortingDropDown(value);
        Assert.assertTrue(productsPage.getActiveOptionText().contains(value));
    }

    @Given("Click on {string} item title")
    public void clickOnStringItem(String value) {
        productsPage = new ProductsPage(driver.getDriver());
        productsPage.selectAnItem(value);
    }

    @And("Click on Add Button and verify that {string} items have been added")
    public void clickOnAddToCart(String value){
        productsPage = new ProductsPage(driver.getDriver());
        productsPage.addTheItemToTheCart();
        Assert.assertTrue(productsPage.getAddedItemBadgeText().contains(value));
    }

    @And("Click on the cart")
    public void clickOnTheCart(){
        productsPage = new ProductsPage(driver.getDriver());
        productsPage.clickOnTheCart();
    }

    @And("Select 'Back to products' button")
    public void clickOnBackToProducts(){
        productsPage = new ProductsPage(driver.getDriver());
        productsPage.clickOnBackToProductsButton();
    }

    @And("Verify that the cart is empty")
    public void verifyTheEmptyCart(){
        productsPage = new ProductsPage(driver.getDriver());
        Assert.assertTrue(productsPage.getShoppingCartBadgeEmpty().isEmpty());
    }

    @And("Add {string} item to the cart from Products Page")
    public void addAnItemFromProductsPage(String text){
        productsPage = new ProductsPage(driver.getDriver());
        productsPage.addAnItem(text);
    }

    @And("Click on 'Remove' button for {string} item")
    public void clickOnRemoveButtonFromProductsPage(){
        productsPage = new ProductsPage(driver.getDriver());

    }

}
