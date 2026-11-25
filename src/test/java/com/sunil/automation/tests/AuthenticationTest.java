
package com.sunil.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sunil.automation.base.BaseTest;
import com.sunil.automation.config.ConfigReader;
import com.sunil.automation.pages.HomePage;
import com.sunil.automation.pages.LoginPage;
import com.sunil.automation.pages.RegistrationPage;
import com.sunil.automation.utils.TestDataGenerator;

public class AuthenticationTest extends BaseTest {

    @Test(groups = {"regression", "e2e"})
    public void verifyValidLoginAndLogout() {

        String name = TestDataGenerator.generateName();
        String email = TestDataGenerator.generateEmail();
        String password = TestDataGenerator.generatePassword();

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage =
                homePage.navigateToLoginPage();

        // Create a temporary test account
        RegistrationPage registrationPage =
                loginPage.signup(name, email);

        registrationPage.fillAccountInformation(password);
        registrationPage.fillAddressInformation();
        registrationPage.createAccount();

        Assert.assertTrue(
                registrationPage.getAccountCreatedMessage()
                        .equalsIgnoreCase("Account Created!"),
                "Test account creation failed");

        try {

            HomePage registeredHomePage =
                    registrationPage.continueToHomePage();

            Assert.assertEquals(
                    registeredHomePage.getLoggedInUsername(),
                    name,
                    "Registered username verification failed");

            // Verify logout
            LoginPage loggedOutPage =
                    registeredHomePage.logout();

            Assert.assertEquals(
                    loggedOutPage.getLoginHeading(),
                    "Login to your account",
                    "Logout navigation failed");

            Assert.assertFalse(
                    homePage.isLoggedIn(),
                    "User is still logged in");

            System.out.println("Logout successful");

            // Verify valid login
            loggedOutPage.login(email, password);

            Assert.assertEquals(
                    homePage.getLoggedInUsername(),
                    name,
                    "Valid login verification failed");

            System.out.println("Valid login successful");

        } finally {

            // Clean up temporary test account
            driver.get(ConfigReader.getProperty("baseUrl"));

            if (!homePage.isLoggedIn()) {
                homePage.navigateToLoginPage()
                        .login(email, password);
            }

            Assert.assertEquals(
                    homePage.getLoggedInUsername(),
                    name,
                    "Cleanup user verification failed");

            homePage.deleteAccount();

            Assert.assertTrue(
                    homePage.getAccountDeletedMessage()
                            .equalsIgnoreCase("Account Deleted!"),
                    "Account cleanup failed");

            System.out.println("Test account deleted");
        }
    }
}
