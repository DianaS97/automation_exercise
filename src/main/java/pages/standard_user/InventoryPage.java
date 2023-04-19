package pages.standard_user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionUtil;

import java.time.Duration;

public class InventoryPage {

    WebDriverWait wait;

    ActionUtil actionUtil;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private WebElement addToCartElement; //Triggers all elements


    //Select one item from Products: Sauce Labs Bike Light
    @FindBy(xpath = "//a[@id='item_0_title_link']")
    private WebElement bikeLightItemClickableTitle;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement bikeLightItemAddToCartButton;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    private WebElement bikeLightItemDescription;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    private WebElement bikeLightItemPrice;

    @FindBy(xpath = "//div[@class='inventory_details_img_container']")
    private WebElement bikeLightItemImage;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    private WebElement bikeLightItemTitle;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backToProductsButton;



    //Sorting elements

    //Select the dropdown
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement dropDownSortingElements;

    @FindBy(xpath = "//span[@class='active_option']")
    private WebElement activeOptionElement;


    public InventoryPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(ActionUtil.DEFAULT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }


    public void selectTheSortingDropDown(String text) {
        wait.until(ExpectedConditions.visibilityOf(dropDownSortingElements));
        Select selectLocation = new Select(dropDownSortingElements);
        selectLocation.selectByVisibleText(text);
    }

    /*public String verifyTheActiveOption() {
        wait.until(ExpectedConditions.visibilityOf(activeOptionElement));
        return actionUtil.getAttributeValue(activeOptionElement, "active-option");
    }*/

    public String getActiveOptionText(){
        wait.until(ExpectedConditions.elementToBeClickable(activeOptionElement));
        return activeOptionElement.getText();
    }

}
