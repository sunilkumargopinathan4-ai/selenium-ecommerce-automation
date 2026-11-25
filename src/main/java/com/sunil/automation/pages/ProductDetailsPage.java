
package com.sunil.automation.pages;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private final By productName =
            By.cssSelector(".product-information h2");

    private final By productPrice =
            By.cssSelector(".product-information span span");

    private final By quantityInput =
            By.id("quantity");

    private final By addToCartButton =
            By.cssSelector("button.cart");

    private final By viewCartLink =
            By.cssSelector("#cartModal a[href='/view_cart']");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {

        return getText(productName);
    }

    public BigDecimal getProductPrice() {

        String price = getText(productPrice);

        return new BigDecimal(
                price.replace("Rs.", "")
                     .replace(",", "")
                     .trim());
    }

    public void setQuantity(int quantity) {

        enterText(quantityInput,
                String.valueOf(quantity));
    }

    public CartPage addProductToCart() {

        click(addToCartButton);

        click(viewCartLink);

        return new CartPage(driver);
    }
}

