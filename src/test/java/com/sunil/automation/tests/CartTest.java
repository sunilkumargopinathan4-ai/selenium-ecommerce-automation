
package com.sunil.automation.tests;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sunil.automation.base.BaseTest;
import com.sunil.automation.pages.HomePage;
import com.sunil.automation.pages.ProductsPage;
import com.sunil.automation.pages.ProductDetailsPage;
import com.sunil.automation.pages.CartPage;

public class CartTest extends BaseTest {

    @Test(groups = {"regression"})
    public void verifyProductQuantityAndTotal() {

        int productId = 1;
        int expectedQuantity = 4;

        HomePage homePage = new HomePage(driver);

        ProductsPage productsPage =
                homePage.navigateToProductsPage();

        ProductDetailsPage detailsPage =
                productsPage.openProductDetails(productId);

        String expectedName =
                detailsPage.getProductName();

        BigDecimal expectedPrice =
                detailsPage.getProductPrice();

        Assert.assertEquals(expectedName, "Blue Top",
                "Incorrect product details page");

        detailsPage.setQuantity(expectedQuantity);

        CartPage cartPage =
                detailsPage.addProductToCart();

        Assert.assertEquals(
                cartPage.getProductName(productId),
                expectedName,
                "Cart product name mismatch");

        Assert.assertEquals(
                cartPage.getProductPrice(productId)
                        .compareTo(expectedPrice),
                0,
                "Cart product price mismatch");

        Assert.assertEquals(
                cartPage.getProductQuantity(productId),
                expectedQuantity,
                "Cart product quantity mismatch");

        BigDecimal expectedTotal =
                expectedPrice.multiply(
                        BigDecimal.valueOf(expectedQuantity));

        BigDecimal actualTotal =
                cartPage.getProductTotal(productId);

        Assert.assertEquals(
                actualTotal.compareTo(expectedTotal),
                0,
                "Cart total amount mismatch");

        System.out.println("Product: " + expectedName);
        System.out.println("Unit price: " + expectedPrice);
        System.out.println("Quantity: " + expectedQuantity);
        System.out.println("Expected total: " + expectedTotal);
        System.out.println("Actual total: " + actualTotal);

        System.out.println(
                "Cart quantity and total successfully validated");
    }

    @Test(groups = {"regression"})
    public void verifyRemoveProductFromCart() {

        int productId = 1;

        HomePage homePage = new HomePage(driver);

        ProductsPage productsPage =
                homePage.navigateToProductsPage();

        ProductDetailsPage detailsPage =
                productsPage.openProductDetails(productId);

        detailsPage.setQuantity(1);

        CartPage cartPage =
                detailsPage.addProductToCart();

        Assert.assertEquals(
                cartPage.getProductName(productId),
                "Blue Top",
                "Product was not added correctly");

        cartPage.removeProduct(productId);

        Assert.assertTrue(
                cartPage.getEmptyCartMessage()
                        .contains("Cart is empty!"),
                "Cart is not empty after removing product");

        System.out.println(
                "Product successfully removed from cart");
    }
}

