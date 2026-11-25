
package com.sunil.automation.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private final By productsHeading =
            By.cssSelector(".features_items h2.title");

    private final By searchInput =
            By.id("search_product");

    private final By searchButton =
            By.id("submit_search");

    private final By productNames =
            By.cssSelector(".features_items .productinfo p");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductsHeading() {
        return getText(productsHeading);
    }

    public void searchProduct(String productName) {

        enterText(searchInput, productName);

        click(searchButton);
    }

    public List<String> getProductNames() {

        waitForVisible(productNames);

        List<WebElement> elements = wait.until(
                ExpectedConditions
                    .visibilityOfAllElementsLocatedBy(productNames));

        List<String> names = new ArrayList<>();

        for (WebElement element : elements) {

            names.add(element.getText());
        }

        return names;
    }
    public ProductDetailsPage openProductDetails(int productId) {

        By viewProductLink = By.cssSelector(
                "a[href='/product_details/" + productId + "']");

        click(viewProductLink);

        return new ProductDetailsPage(driver);
    }
}
