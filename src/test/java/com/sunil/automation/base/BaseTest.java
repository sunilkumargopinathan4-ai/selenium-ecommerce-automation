
package com.sunil.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.sunil.automation.config.ConfigReader;
import com.sunil.automation.factory.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        String browser = ConfigReader.getProperty("browser");

        String baseUrl = ConfigReader.getProperty("baseUrl");

        driver = DriverFactory.createDriver(browser);

        if (!Boolean.parseBoolean(
                System.getProperty("headless", "false"))) {

            driver.manage().window().maximize();
        }

        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(Integer.parseInt(
                        ConfigReader.getProperty("pageLoadTimeout"))));

        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
    public WebDriver getDriver() {

        return driver;
    }
}
