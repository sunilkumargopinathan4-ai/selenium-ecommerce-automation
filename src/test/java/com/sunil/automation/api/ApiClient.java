
package com.sunil.automation.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import com.sunil.automation.config.ConfigReader;

public class ApiClient {

    public static RequestSpecification request() {

        return RestAssured.given()

                .baseUri(
                    ConfigReader.getProperty("apiBaseUrl"))

                .basePath("/api")

                .log().ifValidationFails();
    }
}

