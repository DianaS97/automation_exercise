package pages.standard_user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionUtil;

import java.time.Duration;


public class CheckoutPage {

    WebDriverWait wait;


    @FindBy(xpath = "//span[@class='title']")
    private WebElement pageHeaderTitleElement;

    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button' and contains(text(), 'Remove')]")
    private WebElement removeButton; //contains all remove buttons

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backHomeButton;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;



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

    @FindBy(xpath = "//div[@class='summary_info']")
    private WebElement summaryInfoBoxElement;


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

    public void selectContinueShoppingButton(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }

    public void clickOnCheckoutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }

    public void clickOnContinueButton(){
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
    }

    public void insertValidData(String firstName, String lastName, String postalCode){
        wait.until(ExpectedConditions.elementToBeClickable(firstNameFieldElement));
        firstNameFieldElement.sendKeys(firstName);
        lastNameFieldElement.sendKeys(lastName);
        postalCodeFieldElement.sendKeys(postalCode);
    }

    public void insertInvalidDataLastNameMissing(String firstName, String postalCode){
        wait.until(ExpectedConditions.elementToBeClickable(firstNameFieldElement));
        firstNameFieldElement.sendKeys(firstName);
        postalCodeFieldElement.sendKeys(postalCode);
    }

    public void insertInvalidDataPostalCodeMissing(String firstName, String lastName){
        wait.until(ExpectedConditions.elementToBeClickable(firstNameFieldElement));
        firstNameFieldElement.sendKeys(firstName);
        lastNameFieldElement.sendKeys(lastName);
    }

    public void insertInvalidDataFirstNameMissing(String lastName, String postalCode){
        wait.until(ExpectedConditions.elementToBeClickable(lastNameFieldElement));
        lastNameFieldElement.sendKeys(lastName);
        postalCodeFieldElement.sendKeys(postalCode);
    }

    public void clickOnFinishButton(){
        wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        finishButton.click();
    }

    public void clickOnBackHomeButton(){
        wait.until(ExpectedConditions.elementToBeClickable(backHomeButton));
        backHomeButton.click();
    }

    public String getCompleteOrderMessageTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(thankYouForYourOrderTitleElement));
        return thankYouForYourOrderTitleElement.getText();
    }

    public String getCompleteOrderMessageDescription() {
        wait.until(ExpectedConditions.elementToBeClickable(completeOrderMessageElement));
        return completeOrderMessageElement.getText();
    }

    public boolean getCompleteOrderImage() {
        wait.until(ExpectedConditions.elementToBeClickable(completeImageElement));
        return completeImageElement.isDisplayed();
    }

    public String getPageTitleHeaderText(){
        wait.until(ExpectedConditions.elementToBeClickable(pageHeaderTitleElement));
        return pageHeaderTitleElement.getText();
    }

    public void clickOnCancelButton(){
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButton.click();
    }

    public void clickOnContinueShoppingButton(){
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }


    public String getSummaryInfoText(){
        wait.until(ExpectedConditions.visibilityOf(summaryInfoBoxElement));
        return summaryInfoBoxElement.getText();
    }


    public String getTheErrorMessageText(){
        wait.until(ExpectedConditions.visibilityOf(errorMessageElement));
        return errorMessageElement.getText();
    }

    public void clickOnRemoveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeButton.click();
    }

    public void clickOnRemoveButtonProductsPage(){

    }




}
