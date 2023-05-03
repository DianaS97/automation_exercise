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

public class Hooks {

    private final Driver driver;

    public Hooks(Driver driver) {
        this.driver = driver;
    }

    /*@Before
    public void initializeDriver(String selectBrowser) {
        driver.setDriver(selectBrowser);
    }*/


    @After(order = 1)
    public void takePrintScreenReport(Scenario scenario) {

        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH_mm_ss").format(timestamp);
            String screenShotName = scenario.getName().replaceAll(" ", "_");

            try {
                //Convert web driver object to TakeScreenshot and Call getScreenshotAs method to create image file
                File sourcePath = ((TakesScreenshot) driver.getDriver()).getScreenshotAs(OutputType.FILE);
                //Move image file to new destination
                File destinationPath = new File(System.getProperty("reports.dir") + "~/.git-ignores/" + screenShotName + "-" + timestamp.getTime() + "-" + simpleDateFormat + ".gitignore");
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

