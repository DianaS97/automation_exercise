package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionUtil {
    private WebDriverWait wait;
    private Actions action;

    public static long DEFAULT_TIMEOUT = 10;

    public ActionUtil(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        action = new Actions(driver);
    }


    public void doubleClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        action.doubleClick(element).perform();
    }

    public void hover(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        action.moveToElement(element).perform();
    }

    public String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }


}
