package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionUtil;

import java.time.Duration;

public class LoginPage {

    WebDriverWait wait;


    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessageElement;


    public LoginPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(ActionUtil.DEFAULT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }


    public void setStandardUser(String standardUser) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(standardUser);
    }

    public void setLockedOutUser(String lockedOutUser) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(lockedOutUser);
    }

    public void setProblemUser(String problemUser) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(problemUser);
    }

    public void setPerformanceGlitchUser(String performanceGlitchUser) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(performanceGlitchUser);
    }


    public void loginStandardUser(String standardUser, String password) {
        setStandardUser(standardUser);
        setPassword(password);

    }

    public void loginLockedOutUser(String lockedOutUser, String password) {
        setLockedOutUser(lockedOutUser);
        setPassword(password);
    }

    public void loginProblemUser(String problemUser, String password) {
        setProblemUser(problemUser);
        setPassword(password);
    }

    public void loginPerformanceGlitchUser(String performanceGlitchUser, String password) {
        setPerformanceGlitchUser(performanceGlitchUser);
        setPassword(password);
    }


    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
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
