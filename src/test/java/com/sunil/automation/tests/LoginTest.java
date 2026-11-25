
package com.sunil.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sunil.automation.base.BaseTest;
import com.sunil.automation.pages.HomePage;
import com.sunil.automation.pages.LoginPage;
import com.sunil.automation.testdata.LoginTestData;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyLoginPageNavigation() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage =
                homePage.navigateToLoginPage();

        Assert.assertEquals(
                loginPage.getLoginHeading(),
                "Login to your account",
                "Login page heading verification failed");
    }

    @Test(
        groups = {"regression", "negative"},
        dataProvider = "invalidLoginData",
        dataProviderClass = LoginTestData.class
    )
    public void verifyLoginWithInvalidCredentials(
            String email, String password) {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage =
                homePage.navigateToLoginPage();

        loginPage.login(email, password);

        Assert.assertEquals(
                loginPage.getLoginErrorMessage(),
                "Your email or password is incorrect!",
                "Invalid login error verification failed");

        System.out.println(
                "Invalid login successfully validated: " + email);
    }
}
