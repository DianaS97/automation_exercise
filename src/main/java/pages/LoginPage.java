package pages;

import managers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Driver {

    WebDriverWait wait;

    public static long DEFAULT_TIMEOUT = 10;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessageElement;


    public LoginPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }


    public void loginAs(String userType, String password){
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(userType);
        passwordInput.sendKeys(password);
    }


    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }


    public String getLockedOutErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessageElement));
        return errorMessageElement.getText();
    }
}
