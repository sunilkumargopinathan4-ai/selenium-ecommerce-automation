
package com.sunil.automation.pages;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By emptyCartMessage =
            By.id("empty_cart");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By cartRow(int productId, String selector) {

        return By.cssSelector(
                "#product-" + productId + " " + selector);
    }

    public String getProductName(int productId) {

        return getText(
                cartRow(productId, ".cart_description h4 a"));
    }

    public BigDecimal getProductPrice(int productId) {

        String price = getText(
                cartRow(productId, ".cart_price p"));

        return parsePrice(price);
    }

    public int getProductQuantity(int productId) {

        String quantity = getText(
                cartRow(productId, ".cart_quantity button"));

        return Integer.parseInt(quantity.trim());
    }

    public BigDecimal getProductTotal(int productId) {

        String total = getText(
                cartRow(productId, ".cart_total_price"));

        return parsePrice(total);
    }

    public void removeProduct(int productId) {

        click(cartRow(productId, ".cart_quantity_delete"));

        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                    By.id("product-" + productId)));
    }

    public String getEmptyCartMessage() {

        return getText(emptyCartMessage);
    }

    private BigDecimal parsePrice(String price) {

        return new BigDecimal(
                price.replace("Rs.", "")
                     .replace(",", "")
                     .trim());
    }
}
