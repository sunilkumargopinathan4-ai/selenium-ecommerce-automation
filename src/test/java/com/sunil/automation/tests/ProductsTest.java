
package com.sunil.automation.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sunil.automation.base.BaseTest;
import com.sunil.automation.pages.HomePage;
import com.sunil.automation.pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyAllProductsPage() {

        HomePage homePage = new HomePage(driver);

        ProductsPage productsPage =
                homePage.navigateToProductsPage();

        Assert.assertTrue(
                productsPage.getProductsHeading()
                        .equalsIgnoreCase("All Products"),
                "All Products heading is not displayed");

        List<String> productNames =
                productsPage.getProductNames();

        Assert.assertFalse(
                productNames.isEmpty(),
                "No products are displayed");

        System.out.println(
                "Total products displayed: " + productNames.size());
    }

    @Test(groups = {"regression"})
    public void verifyProductSearch() {

        String searchKeyword = "Blue Top";

        HomePage homePage = new HomePage(driver);

        ProductsPage productsPage =
                homePage.navigateToProductsPage();

        productsPage.searchProduct(searchKeyword);

        Assert.assertTrue(
                productsPage.getProductsHeading()
                        .equalsIgnoreCase("Searched Products"),
                "Searched Products heading is not displayed");

        List<String> searchResults =
                productsPage.getProductNames();

        Assert.assertFalse(
                searchResults.isEmpty(),
                "No search results found");

        for (String productName : searchResults) {

            System.out.println(
                    "Search result: " + productName);
        }

        Assert.assertTrue(
                searchResults.contains(searchKeyword),
                "Expected product not found in search results");

        System.out.println(
                "Product search successfully validated");
    }
}
