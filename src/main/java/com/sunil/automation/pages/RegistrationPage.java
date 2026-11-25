
package com.sunil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    private final By accountHeading =
            By.cssSelector("#form h2.title");

    private final By titleMr = By.id("id_gender1");

    private final By password = By.id("password");

    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");

    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By company = By.id("company");
    private final By address = By.id("address1");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");

    private final By createAccountButton =
            By.cssSelector("[data-qa='create-account']");

    private final By accountCreated =
            By.cssSelector("[data-qa='account-created']");

    private final By continueButton =
            By.cssSelector("[data-qa='continue-button']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountInformationHeading() {
        return getText(accountHeading);
    }

    public void fillAccountInformation(String userPassword) {

        click(titleMr);

        enterText(password, userPassword);

        new Select(waitForVisible(days))
                .selectByValue("15");

        new Select(waitForVisible(months))
                .selectByValue("6");

        new Select(waitForVisible(years))
                .selectByValue("1998");
    }

    public void fillAddressInformation() {

        enterText(firstName, "Test");
        enterText(lastName, "User");
        enterText(company, "Demo QA Company");
        enterText(address, "100 Example Street");

        new Select(waitForVisible(country))
                .selectByVisibleText("United States");

        enterText(state, "Test State");
        enterText(city, "Test City");
        enterText(zipcode, "12345");
        enterText(mobileNumber, "2025550147");
    }

    public void createAccount() {
        click(createAccountButton);
    }

    public String getAccountCreatedMessage() {
        return getText(accountCreated);
    }

    public HomePage continueToHomePage() {

        click(continueButton);

        return new HomePage(driver);
    }
}
