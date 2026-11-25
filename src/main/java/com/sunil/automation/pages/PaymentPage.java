
package com.sunil.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    private final By nameOnCard =
            By.cssSelector("[data-qa='name-on-card']");

    private final By cardNumber =
            By.cssSelector("[data-qa='card-number']");

    private final By cvc =
            By.cssSelector("[data-qa='cvc']");

    private final By expiryMonth =
            By.cssSelector("[data-qa='expiry-month']");

    private final By expiryYear =
            By.cssSelector("[data-qa='expiry-year']");

    private final By payButton =
            By.cssSelector("[data-qa='pay-button']");

    private final By orderPlacedMessage =
            By.cssSelector("[data-qa='order-placed']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void enterPaymentDetails(
            String name,
            String number,
            String securityCode,
            String month,
            String year) {

        enterText(nameOnCard, name);
        enterText(cardNumber, number);
        enterText(cvc, securityCode);
        enterText(expiryMonth, month);
        enterText(expiryYear, year);
    }

    public void confirmOrder() {

        click(payButton);
    }

    public String getOrderPlacedMessage() {

        return getText(orderPlacedMessage);
    }
}

