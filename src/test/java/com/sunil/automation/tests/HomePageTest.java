
package com.sunil.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sunil.automation.base.BaseTest;
import com.sunil.automation.pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageTitle() {

        HomePage homePage = new HomePage(driver);

        String actualTitle = homePage.getHomePageTitle();

        String expectedTitle = "Automation Exercise";

        System.out.println("Actual Title: " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle,
                "Home page title verification failed");
    }
}
