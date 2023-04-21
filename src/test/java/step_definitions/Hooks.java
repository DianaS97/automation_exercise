package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Hooks extends Driver {

    private final Driver driver;

    public Hooks(Driver driver) {
        this.driver = driver;
    }

    /**
     * Set the default webdriver
     */
    @Before
    public void initializeDriver() {
        driver.setDriver();
    }

    /**
     * Saves a screenshot if a scenario fails
     */
    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH_mm_ss").format(timestamp);

            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                File sourcePath = ((TakesScreenshot) driver.getDriver()).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(System.getProperty("user.dir") + "/reports/screenshots/" + screenshotName + "-" + timestamp.getTime() + "-" + simpleDateFormat + ".png");
                FileUtils.copyFile(sourcePath, destinationPath);
            } catch (IOException ignored) {

            }
        }
    }

    /*@After(order = 0)
        public void quitDriver() {
          driver.getDriver().quit();
        }*/
}

