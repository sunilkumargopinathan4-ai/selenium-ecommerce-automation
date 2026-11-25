
package com.sunil.automation.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

import com.sunil.automation.api.ApiClient;

public class ApiTest {

    @Test(groups = {"api", "smoke", "regression"})
    public void verifyAllProductsAPI() {

        Response response = ApiClient.request()

                .when()
                .get("/productsList");

        JsonPath json = validateResponse(response, 200);

        List<String> products =
                json.getList("products.name", String.class);

        Assert.assertNotNull(products,
                "Products list is missing");

        Assert.assertFalse(products.isEmpty(),
                "Products list is empty");

        Assert.assertTrue(products.contains("Blue Top"),
                "Expected product not found");

        System.out.println(
                "API products retrieved: " + products.size());
    }

    @Test(groups = {"api", "regression"})
    public void verifyAllBrandsAPI() {

        Response response = ApiClient.request()

                .when()
                .get("/brandsList");

        JsonPath json = validateResponse(response, 200);

        List<String> brands =
                json.getList("brands.brand", String.class);

        Assert.assertNotNull(brands,
                "Brands list is missing");

        Assert.assertFalse(brands.isEmpty(),
                "Brands list is empty");

        Assert.assertTrue(brands.contains("Polo"),
                "Expected brand not found");

        System.out.println(
                "API brands entries retrieved: " + brands.size());
    }

    @Test(groups = {"api", "regression"})
    public void verifyProductSearchAPI() {

        Response response = ApiClient.request()

                .contentType(ContentType.URLENC)

                .formParam("search_product", "Blue Top")

                .when()
                .post("/searchProduct");

        JsonPath json = validateResponse(response, 200);

        List<String> products =
                json.getList("products.name", String.class);

        Assert.assertNotNull(products,
                "Search results are missing");

        Assert.assertTrue(products.contains("Blue Top"),
                "Expected product not found");

        System.out.println(
                "API search results: " + products);
    }

    @Test(groups = {"api", "negative", "regression"})
    public void verifySearchWithoutParameterAPI() {

        Response response = ApiClient.request()

                .contentType(ContentType.URLENC)

                .when()
                .post("/searchProduct");

        JsonPath json = validateResponse(response, 400);

        Assert.assertEquals(
                json.getString("message"),
                "Bad request, search_product parameter is missing in POST request.",
                "Incorrect error message");

        System.out.println(
                "Missing search parameter successfully validated");
    }

    @Test(groups = {"api", "negative", "regression"})
    public void verifyInvalidLoginAPI() {

        Response response = ApiClient.request()

                .contentType(ContentType.URLENC)

                .formParam("email",
                        "invalid-user@example.invalid")

                .formParam("password",
                        "InvalidPassword123")

                .when()
                .post("/verifyLogin");

        JsonPath json = validateResponse(response, 404);

        Assert.assertEquals(
                json.getString("message"),
                "User not found!",
                "Incorrect login error message");

        System.out.println(
                "Invalid login API successfully validated");
    }

    private JsonPath validateResponse(
            Response response, int expectedCode) {

        int httpStatus = response.getStatusCode();

        System.out.println(
                "HTTP Status: " + httpStatus);

        Assert.assertTrue(
                httpStatus == 200 ||
                httpStatus == expectedCode,
                "Unexpected HTTP status: " + httpStatus);

        JsonPath json =
                new JsonPath(response.asString());

        int responseCode =
                json.getInt("responseCode");

        System.out.println(
                "JSON Response Code: " + responseCode);

        Assert.assertEquals(
                responseCode,
                expectedCode,
                "API response code mismatch");

        return json;
    }
}

