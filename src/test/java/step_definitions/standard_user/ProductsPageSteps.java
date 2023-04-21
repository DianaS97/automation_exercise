package step_definitions.standard_user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import managers.Driver;
import org.testng.Assert;
import pages.standard_user.CheckoutPage;
import pages.standard_user.ProductsPage;

public class ProductsPageSteps extends Driver {

    Driver driver;
    ProductsPage inventoryPage;


    public ProductsPageSteps(Driver driver) {
        this.driver = driver;
    }

    @And("Sort the items by {string}")
    public void sortTheItems(String value) {
        inventoryPage = new ProductsPage(driver.getDriver());
        inventoryPage.selectTheSortingDropDown(value);
        Assert.assertTrue(inventoryPage.getActiveOptionText().contains(value));
    }

    @Given("Click on {string} item title")
    public void clickOnStringItem(String value) {
        inventoryPage = new ProductsPage(driver.getDriver());
        inventoryPage.selectAnItem(value);
    }

    @And("Click on Add Button and verify that {string} items have been added")
    public void clickOnAddToCart(String value){
        inventoryPage = new ProductsPage(driver.getDriver());
        inventoryPage.addTheItemToTheCart();
        Assert.assertTrue(inventoryPage.getAddedItemBadgeText().contains(value));
    }

    @And("Click on the cart")
    public void clickOnTheCart(){
        inventoryPage = new ProductsPage(driver.getDriver());
        inventoryPage.clickOnTheCart();
    }

    @And("Select 'Back to products' button")
    public void clickOnBackToProducts(){
        inventoryPage = new ProductsPage(driver.getDriver());
        inventoryPage.clickOnBackToProductsButton();
    }



}
