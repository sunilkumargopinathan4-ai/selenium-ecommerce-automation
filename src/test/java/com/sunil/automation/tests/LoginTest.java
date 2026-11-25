
package com.sunil.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sunil.automation.base.BaseTest;
import com.sunil.automation.pages.HomePage;
import com.sunil.automation.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyLoginPageNavigation() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.navigateToLoginPage();

        Assert.assertEquals(
                loginPage.getLoginHeading(),
                "Login to your account",
                "Login page heading verification failed");
    }

    @Test(groups = {"regression", "negative"})
    public void verifyLoginWithInvalidCredentials() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.navigateToLoginPage();

        loginPage.login(
                "invalid-user@example.invalid",
                "InvalidPassword123");

        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                "Your email or password is incorrect!",
                "Invalid login error verification failed");
    }
}
