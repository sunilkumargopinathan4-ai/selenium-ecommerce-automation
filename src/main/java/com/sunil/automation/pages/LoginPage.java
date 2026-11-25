
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
    private final By signupName =
            By.cssSelector("[data-qa='signup-name']");

    private final By signupEmail =
            By.cssSelector("[data-qa='signup-email']");

    private final By signupButton =
            By.cssSelector("[data-qa='signup-button']");
    
    public RegistrationPage signup(String name, String email) {

        enterText(signupName, name);

        enterText(signupEmail, email);

        click(signupButton);

        return new RegistrationPage(driver);
    }
}
    
    
