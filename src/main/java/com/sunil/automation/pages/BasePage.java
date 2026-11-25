
package com.sunil.automation.pages;

import java.time.Duration;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.ElementClickInterceptedException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sunil.automation.config.ConfigReader;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                    Integer.parseInt(
                        ConfigReader.getProperty("explicitWait"))));
    }

    protected WebElement waitForVisible(By locator) {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (TimeoutException e) {

            captureFailure("VisibilityTimeout", locator);

            throw e;
        }
    }

    protected void click(By locator) {

        try {

            wait.until(
                    ExpectedConditions.elementToBeClickable(locator))
                    .click();

        } catch (TimeoutException |
                 ElementClickInterceptedException e) {

            captureFailure("ClickFailure", locator);

            throw e;
        }
    }

    protected void enterText(By locator, String text) {

        WebElement element = waitForVisible(locator);

        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {

        return waitForVisible(locator).getText();
    }

    private void captureFailure(String reason, By locator) {

        try {

            System.err.println("Failure reason: " + reason);
            System.err.println("Failed locator: " + locator);
            System.err.println("Current URL: " + driver.getCurrentUrl());
            System.err.println("Page title: " + driver.getTitle());

            Path directory = Path.of("target", "screenshots");

            Files.createDirectories(directory);

            Path screenshotPath = directory.resolve(
                    reason + "_" + System.currentTimeMillis() + ".png");

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            Files.write(screenshotPath, screenshot);

            System.err.println(
                    "Screenshot saved: " + screenshotPath.toAbsolutePath());

        } catch (Exception e) {

            System.err.println(
                    "Unable to capture failure evidence: " + e.getMessage());
        }
    }
}
