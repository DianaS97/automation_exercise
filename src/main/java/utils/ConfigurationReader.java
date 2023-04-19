package utils;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private String propertyFilePath = "src/test/resources/environments/test.properties";//local is set as default location

    public String testType = "@all";

    private final Properties properties;

    @Parameters({"env", "testType"})
    @BeforeSuite
    public void setEnvironment(String environment) {
    }

    public ConfigurationReader() {
        BufferedReader reader;
        if (System.getProperty("testType") != null) {
            testType = System.getProperty("testType");
        }

        if (System.getProperty("env") != null) {
            propertyFilePath = "src/test/resources/environments/" + System.getProperty("env") + ".properties";
        }

        try {
            properties = new Properties();
            reader = new BufferedReader(new FileReader(propertyFilePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(System.getProperty("env") + ".properties not found at " + propertyFilePath);
        }
    }

    public String getTestType() {
        return testType;
    }


    public String getBrowser() {
        String browser = properties.getProperty("browser");
        if (browser != null) return browser;
        else throw new RuntimeException("browser not specified in the configuration.properties file.");
    }

    public String getLoginUrl() {
        String loginUrl = properties.getProperty("login_url");
        if (loginUrl != null) return loginUrl;
        else throw new RuntimeException("Login url not specified in the configuration.properties file.");
    }

    public String isHeadless() {
        String headless = properties.getProperty("headless");
        if (headless != null) return headless;
        else throw new RuntimeException("headless not specified in the configuration.properties file.");
    }

    public String getStandardUser() {
        String standardUser = properties.getProperty("standardUser");
        if (standardUser != null) return standardUser;
        else throw new RuntimeException("username not specified in the configuration.properties file.");
    }

    public String getLockedOutUser() {
        String lockedOutUser = properties.getProperty("lockedOutUser");
        if (lockedOutUser != null) return lockedOutUser;
        else throw new RuntimeException("username not specified in the configuration.properties file.");
    }

    public String getProblemUser() {
        String problemUser = properties.getProperty("problemUser");
        if (problemUser != null) return problemUser;
        else throw new RuntimeException("username not specified in the configuration.properties file.");
    }

    public String getPerformanceGlitchUser() {
        String performanceGlitchUser = properties.getProperty("performanceGlitchUser");
        if (performanceGlitchUser != null) return performanceGlitchUser;
        else throw new RuntimeException("username not specified in the configuration.properties file.");
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        if (password != null) return password;
        else throw new RuntimeException("password not specified in the configuration.properties file.");
    }

}
