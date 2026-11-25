
package com.sunil.automation.tests;

import com.sunil.automation.utils.TestDataGenerator;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sunil.automation.base.BaseTest;
import com.sunil.automation.pages.HomePage;
import com.sunil.automation.pages.LoginPage;
import com.sunil.automation.pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    @Test(groups = {"regression", "e2e"})
    public void verifySuccessfulRegistration() {

    	String name = TestDataGenerator.generateName();

    	String email = TestDataGenerator.generateEmail();

    	String password = TestDataGenerator.generatePassword();

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage =
                homePage.navigateToLoginPage();

        RegistrationPage registrationPage =
                loginPage.signup(name, email);

        Assert.assertTrue(
                registrationPage.getAccountInformationHeading()
                        .equalsIgnoreCase("Enter Account Information"),
                "Account information page is not displayed");

        registrationPage.fillAccountInformation(password);

        registrationPage.fillAddressInformation();

        registrationPage.createAccount();

        Assert.assertTrue(
                registrationPage.getAccountCreatedMessage()
                        .equalsIgnoreCase("Account Created!"),
                "Account creation failed");

        HomePage registeredHomePage =
                registrationPage.continueToHomePage();

        try {

            Assert.assertEquals(
                    registeredHomePage.getLoggedInUsername(),
                    name,
                    "Logged-in username verification failed");

        } finally {

            registeredHomePage.deleteAccount();
        }

        Assert.assertTrue(
                registeredHomePage.getAccountDeletedMessage()
                        .equalsIgnoreCase("Account Deleted!"),
                "Account deletion failed");

        System.out.println(
                "Registration and account deletion successful");
    }
}
