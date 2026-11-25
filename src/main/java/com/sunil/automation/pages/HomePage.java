
package com.sunil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By loginLink =
            By.cssSelector("a[href='/login']");

    private final By loggedInUsername =
            By.xpath("//a[contains(normalize-space(.), 'Logged in as')]/b");

    private final By deleteAccountLink =
            By.cssSelector("a[href='/delete_account']");

    private final By accountDeleted =
            By.cssSelector("[data-qa='account-deleted']");

    private final By logoutLink =
            By.cssSelector("a[href='/logout']");
    
    
    private final By productsLink =
            By.cssSelector("a[href='/products']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public LoginPage navigateToLoginPage() {
        click(loginLink);
        return new LoginPage(driver);
    }

    public String getLoggedInUsername() {
        return getText(loggedInUsername);
    }

    public void deleteAccount() {
        click(deleteAccountLink);
    }

    public String getAccountDeletedMessage() {
        return getText(accountDeleted);
    }

    public LoginPage logout() {
        click(logoutLink);
        return new LoginPage(driver);
    }

    public boolean isLoggedIn() {
        return !driver.findElements(logoutLink).isEmpty();
    }
    
    
    public ProductsPage navigateToProductsPage() {

        click(productsLink);

        return new ProductsPage(driver);
    }

}
