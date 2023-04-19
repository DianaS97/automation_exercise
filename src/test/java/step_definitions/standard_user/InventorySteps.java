package step_definitions.standard_user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import managers.Driver;
import org.testng.Assert;
import pages.standard_user.InventoryPage;

public class InventorySteps extends Driver {

    Driver driver;
    InventoryPage inventoryPage;

    public InventorySteps(Driver driver){this.driver = driver;}

    @And("Sort the items by {string}")
    public void sortTheItems(String value){
        inventoryPage = new InventoryPage(driver.getDriver());
        inventoryPage.selectTheSortingDropDown(value);
        Assert.assertTrue(inventoryPage.getActiveOptionText().contains(value));
    }

}
