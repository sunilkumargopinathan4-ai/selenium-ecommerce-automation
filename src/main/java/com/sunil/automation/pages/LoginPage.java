
package com.sunil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By loginHeading =
            By.cssSelector(".login-form h2");

    private final By emailInput =
            By.cssSelector("[data-qa='login-email']");

    private final By passwordInput =
            By.cssSelector("[data-qa='login-password']");

    private final By loginButton =
            By.cssSelector("[data-qa='login-button']");

    private final By errorMessage =
            By.cssSelector(".login-form p");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginHeading() {
        return getText(loginHeading);
    }

    public void login(String email, String password) {

        enterText(emailInput, email);

        enterText(passwordInput, password);

        click(loginButton);
    }

    public String getLoginErrorMessage() {
        return getText(errorMessage);
    }
}
