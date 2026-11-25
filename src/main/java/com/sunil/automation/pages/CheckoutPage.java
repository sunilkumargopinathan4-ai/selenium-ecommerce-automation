
package com.sunil.automation.pages;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By deliveryAddress =
            By.id("address_delivery");

    private final By billingAddress =
            By.id("address_invoice");

    private final By orderTotal =
            By.xpath("//tr[.//b[normalize-space()='Total Amount']]"
                    + "//p[contains(@class,'cart_total_price')]");

    private final By orderComment =
            By.cssSelector("textarea[name='message']");

    private final By placeOrderButton =
            By.cssSelector("a[href='/payment']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getDeliveryAddress() {

        return getText(deliveryAddress);
    }

    public String getBillingAddress() {

        return getText(billingAddress);
    }

    public BigDecimal getOrderTotal() {

        String total = getText(orderTotal);

        return new BigDecimal(
                total.replace("Rs.", "")
                     .replace(",", "")
                     .trim());
    }

    public void enterOrderComment(String comment) {

        enterText(orderComment, comment);
    }

    public PaymentPage placeOrder() {

        click(placeOrderButton);

        return new PaymentPage(driver);
    }

}
