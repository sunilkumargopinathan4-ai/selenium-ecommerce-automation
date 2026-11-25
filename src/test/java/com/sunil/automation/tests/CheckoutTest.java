
package com.sunil.automation.tests;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sunil.automation.base.BaseTest;
import com.sunil.automation.config.ConfigReader;
import com.sunil.automation.pages.HomePage;
import com.sunil.automation.pages.RegistrationPage;
import com.sunil.automation.pages.ProductsPage;
import com.sunil.automation.pages.ProductDetailsPage;
import com.sunil.automation.pages.CartPage;
import com.sunil.automation.pages.CheckoutPage;
import com.sunil.automation.pages.PaymentPage;
import com.sunil.automation.utils.TestDataGenerator;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"regression", "e2e"})
    public void verifyCompleteCheckoutWorkflow() {

        String email = TestDataGenerator.generateEmail();

        String name = TestDataGenerator.generateName()
                + " " + email.substring(3, 11);

        String password =
                TestDataGenerator.generatePassword();

        int productId = 1;
        int quantity = 2;

        HomePage homePage = new HomePage(driver);

        // Register a temporary test account
        RegistrationPage registrationPage =
                homePage.navigateToLoginPage()
                        .signup(name, email);

        registrationPage.fillAccountInformation(password);
        registrationPage.fillAddressInformation();
        registrationPage.createAccount();

        Assert.assertTrue(
                registrationPage.getAccountCreatedMessage()
                        .equalsIgnoreCase("Account Created!"),
                "Test account creation failed");

        try {

            HomePage registeredHomePage =
                    registrationPage.continueToHomePage();

            Assert.assertEquals(
                    registeredHomePage.getLoggedInUsername(),
                    name,
                    "Logged-in username mismatch");

            // Select product
            ProductsPage productsPage =
                    registeredHomePage.navigateToProductsPage();

            ProductDetailsPage detailsPage =
                    productsPage.openProductDetails(productId);

            Assert.assertEquals(
                    detailsPage.getProductName(),
                    "Blue Top",
                    "Incorrect product selected");

            BigDecimal unitPrice =
                    detailsPage.getProductPrice();

            detailsPage.setQuantity(quantity);

            // Add product to cart
            CartPage cartPage =
                    detailsPage.addProductToCart();

            Assert.assertEquals(
                    cartPage.getProductQuantity(productId),
                    quantity,
                    "Cart quantity mismatch");

            BigDecimal expectedTotal =
                    unitPrice.multiply(
                            BigDecimal.valueOf(quantity));

            Assert.assertEquals(
                    cartPage.getProductTotal(productId)
                            .compareTo(expectedTotal),
                    0,
                    "Cart total mismatch");

            // Checkout
            CheckoutPage checkoutPage =
                    cartPage.proceedToCheckout();

            String deliveryAddress =
                    checkoutPage.getDeliveryAddress();

            String billingAddress =
                    checkoutPage.getBillingAddress();

            String[] expectedAddressDetails = {
                "Test User",
                "Demo QA Company",
                "100 Example Street",
                "Test City",
                "Test State",
                "12345",
                "United States",
                "2025550147"
            };

            for (String detail : expectedAddressDetails) {

                Assert.assertTrue(
                        deliveryAddress.contains(detail),
                        "Delivery address missing: " + detail);

                Assert.assertTrue(
                        billingAddress.contains(detail),
                        "Billing address missing: " + detail);
            }

            System.out.println(
                    "Delivery and billing addresses validated");

            BigDecimal actualTotal =
                    checkoutPage.getOrderTotal();

            Assert.assertEquals(
                    actualTotal.compareTo(expectedTotal),
                    0,
                    "Checkout total mismatch");

            System.out.println(
                    "Expected order total: " + expectedTotal);

            System.out.println(
                    "Actual order total: " + actualTotal);

            checkoutPage.enterOrderComment(
                    "Automated demo order for QA testing");

            PaymentPage paymentPage =
                    checkoutPage.placeOrder();

            // Fictional payment data for demo website only
            paymentPage.enterPaymentDetails(
                    "Test User",
                    "4111111111111111",
                    "123",
                    "12",
                    "2035");

            paymentPage.confirmOrder();

            Assert.assertTrue(
                    paymentPage.getOrderPlacedMessage()
                            .equalsIgnoreCase("Order Placed!"),
                    "Order confirmation failed");

            System.out.println(
                    "Demo order placed successfully");

        } finally {

            // Clean up temporary test account
            driver.get(ConfigReader.getProperty("baseUrl"));

            if (!homePage.isLoggedIn()) {

                homePage.navigateToLoginPage()
                        .login(email, password);
            }

            Assert.assertEquals(
                    homePage.getLoggedInUsername(),
                    name,
                    "Cleanup user verification failed");

            homePage.deleteAccount();

            Assert.assertTrue(
                    homePage.getAccountDeletedMessage()
                            .equalsIgnoreCase("Account Deleted!"),
                    "Test account cleanup failed");

            System.out.println(
                    "Checkout test account deleted");
        }
    }
}

