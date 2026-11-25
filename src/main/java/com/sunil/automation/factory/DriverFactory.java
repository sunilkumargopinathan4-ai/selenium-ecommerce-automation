
package com.sunil.automation.factory;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        switch (browser.toLowerCase()) {

            case "chrome":

                ChromeDriver chromeDriver = new ChromeDriver();

                if (Boolean.parseBoolean(
                        System.getProperty("blockAds", "true"))) {
                    blockAdvertisements(chromeDriver);
                }

                return chromeDriver;

            case "firefox":
                return new FirefoxDriver();

            case "edge":
                return new EdgeDriver();

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser);
        }
    }

    private static void blockAdvertisements(ChromeDriver driver) {

        driver.executeCdpCommand(
                "Network.enable",
                Map.of());

        driver.executeCdpCommand(
                "Network.setBlockedURLs",
                Map.of("urls", List.of(
                        "*://*.googlesyndication.com/*",
                        "*://*.doubleclick.net/*",
                        "*://*.googleadservices.com/*"
                )));

        System.out.println("Advertisement blocking enabled");
    }
}
