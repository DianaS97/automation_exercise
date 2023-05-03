package pages.standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    WebDriverWait wait;

    public static long DEFAULT_TIMEOUT = 10;


    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement appLogoSwagLabs;

    @FindBy(xpath = "//div[@class='footer_copy']")
    private WebElement copyRightsTextElement;

    @FindBy(xpath = "//ul[@class='social']")
    private WebElement socialMediasElement;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private List<WebElement> addToCartButtonListElements;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private WebElement addToCartButtonElement; //Triggers all elements

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement clickOnCartElement;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement shoppingCartBadgeAssertElement;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartBadgeEmptyAssertElement;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> inventoryItemNameElements;

    //List<WebElement>

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


    public ProductsPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    public String getAppLogoText() {
        wait.until(ExpectedConditions.visibilityOf(appLogoSwagLabs));
        return appLogoSwagLabs.getText();
    }

    public String getCopyRightsFooterText() {
        wait.until(ExpectedConditions.visibilityOf(copyRightsTextElement));
        return copyRightsTextElement.getText();
    }

    public String getTheSocialMediasText() {
        wait.until(ExpectedConditions.visibilityOf(socialMediasElement));
        return socialMediasElement.getText();
    }


    public void selectTheSortingDropDown(String text) {
        wait.until(ExpectedConditions.visibilityOf(dropDownSortingElements));
        Select selectLocation = new Select(dropDownSortingElements);
        selectLocation.selectByVisibleText(text);
    }


    public String getActiveOptionText() {
        wait.until(ExpectedConditions.elementToBeClickable(activeOptionElement));
        return activeOptionElement.getText();
    }


    public void selectAnItem(String value) {
        for (WebElement item : inventoryItemNameElements) {
            if (item.getText().equals(value)) {
                item.click();
                break;
            }
        }
    }

    public void addTheItemToTheCart(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonElement));
        addToCartButtonElement.click();
    }


    public String getAddedItemBadgeText() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartBadgeAssertElement));
        return shoppingCartBadgeAssertElement.getText();
    }

    public void clickOnTheCart(){
        wait.until(ExpectedConditions.elementToBeClickable(clickOnCartElement));
        clickOnCartElement.click();
    }

    public void clickOnBackToProductsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(backToProductsButton));
        backToProductsButton.click();
    }

    public String getShoppingCartBadgeEmpty(){
        wait.until(ExpectedConditions.visibilityOf(shoppingCartBadgeEmptyAssertElement));
        return shoppingCartBadgeEmptyAssertElement.getText();
    }


    /*public void addAnItem(String value) {
        for (WebElement item : inventoryItemNameElements) {
            if (item.getText().contains(value)) {
                wait.until(ExpectedConditions.elementToBeClickable(item));
                item.click();
                wait.until(ExpectedConditions.attributeContains(item, "class", "Add-to-cart"));

                break;
            }
        }
    }*/

    public void addAnItem(String text) {
        List<WebElement> items = inventoryItemNameElements;
        for (WebElement item : items) {
            // locate the item element

            if (items.equals(text)) {
                // locate add to cart button
                item.findElement(By.xpath("//div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/button[text()='Add to cart']")).click();
                System.out.println(item);
                System.out.println("clicked add to cart");
                break;
            }
        }
    }

    /*public void addAnItem(String value) {
        for (WebElement item : inventoryItemNameElements) {
            if (item.getText().equals(value)) {
                item.findElement(By.xpath("//div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/button[text()='Add to cart']")).click();
                break;
            }
        }
    }*/



}
