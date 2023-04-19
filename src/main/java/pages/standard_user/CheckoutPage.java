package pages.standard_user;

import managers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionUtil;

import java.time.Duration;

public class CheckoutPage {

    Driver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageHeaderTitleElement;

    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button' and contains(text(), 'Remove')]")
    private WebElement removeButton; //contains all remove buttons

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backHomeButton;



    //CHECKOUT: OVERVIEW PAGE
    //Verify the items in the cart: QTY, Description, Title of the item, Description of the item, Item's Price
    @FindBy(xpath = "//div[@class='cart_quantity_label']")
    private WebElement qtyElement;

    @FindBy(xpath = "//div[@class='cart_desc_label']")
    private WebElement descriptionElement;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement titleItemElement;

    @FindBy(xpath = "//div[@class='inventory_item_desc']")
    private WebElement descriptionItemElement;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private WebElement priceItemElement;

    //Verify the Summary Info: Payment Information, Shipping Information, Price Total, Total
    @FindBy(xpath = "//div[@class='summary_info_label']")   //Payment Title, Shipping Title, Price Total Title
    private WebElement labelElement;

    @FindBy(xpath = "//div[@class='summary_value_label']")  //Payment value, Shipping value
    private WebElement valueElement;


    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement itemTotalElement;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement taxElement;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement finalTotalElement;



    //CHECKOUT: YOUR INFORMATION PAGE
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameFieldElement;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameFieldElement;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCodeFieldElement;

    @FindBy(xpath = "//div[@class='error-message-container error']") //When the user does not fill out the form properly an error message appears
    private WebElement errorMessageElement;


    //CHECKOUT: COMPLETE! PAGE
    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement thankYouForYourOrderTitleElement;

    @FindBy(xpath = "//div[@class='complete-text']")
    private WebElement completeOrderMessageElement;

    @FindBy(xpath = "//img[@alt='Pony Express']")
    private WebElement completeImageElement;

    public CheckoutPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(ActionUtil.DEFAULT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }


}
