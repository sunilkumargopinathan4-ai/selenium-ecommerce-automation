
package com.sunil.automation.listeners;

import org.openqa.selenium.WebDriver;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import com.sunil.automation.base.BaseTest;
import com.sunil.automation.utils.ScreenshotUtils;

public class FailureListener
        implements IInvokedMethodListener {

    @Override
    public void afterInvocation(
            IInvokedMethod method,
            ITestResult result) {

        if (!method.isTestMethod()
                || result.getStatus() != ITestResult.FAILURE) {

            return;
        }

        String testName = result.getMethod().getMethodName();

        System.err.println("Failed test: " + testName);

        if (result.getThrowable() != null) {

            System.err.println(
                    "Failure reason: "
                    + result.getThrowable().getMessage());
        }

        Object testInstance = result.getInstance();

        if (testInstance instanceof BaseTest) {

            BaseTest baseTest = (BaseTest) testInstance;

            WebDriver driver = baseTest.getDriver();

            if (driver != null) {

                try {

                    System.err.println(
                            "Current URL: "
                            + driver.getCurrentUrl());

                    System.err.println(
                            "Page title: "
                            + driver.getTitle());

                } catch (Exception e) {

                    System.err.println(
                            "Browser session unavailable");
                }
            }

            ScreenshotUtils.captureScreenshot(
                    driver, testName);

        } else {

            System.err.println(
                    "Non-UI test: browser screenshot not applicable");
        }
    }
}

