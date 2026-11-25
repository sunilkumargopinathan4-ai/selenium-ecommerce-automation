
package com.sunil.automation.utils;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import io.qameta.allure.Allure;

public class ScreenshotUtils {

    public static Path captureScreenshot(
            WebDriver driver, String testName) {

        if (driver == null) {

            System.err.println(
                    "Screenshot unavailable: browser not initialized");

            return null;
        }

        try {

            Path directory =
                    Path.of("target", "screenshots");

            Files.createDirectories(directory);

            String fileName = testName
                    + "_" + UUID.randomUUID()
                    + ".png";

            Path screenshotPath =
                    directory.resolve(fileName);

            byte[] screenshot =
                    ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            Files.write(screenshotPath, screenshot);

            System.out.println(
                    "Failure screenshot saved: "
                    + screenshotPath.toAbsolutePath());

            try {

                Allure.addAttachment(
                        "Failure Screenshot",
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        ".png");

            } catch (Exception e) {

                System.err.println(
                        "Allure attachment failed: "
                        + e.getMessage());
            }

            return screenshotPath;

        } catch (Exception e) {

            System.err.println(
                    "Unable to capture screenshot: "
                    + e.getMessage());

            return null;
        }
    }
}
