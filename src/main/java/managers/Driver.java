package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.picocontainer.Startable;
import utils.ConfigurationReader;

public class Driver implements Startable {

    private  final ConfigurationReader configurationReader = new ConfigurationReader();
    private WebDriver driver;

    public synchronized WebDriver getDriver() {
        return driver;
    }

    public void setDriver() {
        String browser = configurationReader.getBrowser();
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--safebrowsing-disable-download-protection");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--remote-allow-origins=*");
                if (configurationReader.isHeadless().equalsIgnoreCase("true")) {
                    chromeOptions.addArguments("--headless");
                }
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (configurationReader.isHeadless().equalsIgnoreCase("true")) {
                    firefoxOptions.addArguments("--headless");
                }
                firefoxOptions.addArguments("--start-maximized");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
    }

    public void startSecretSauce(){
        String loginUrl = configurationReader.getLoginUrl();
        driver.get(loginUrl);
    }

    public void start() {
        // do nothing
    }

    public void stop() {
        // do nothing
    }

}
