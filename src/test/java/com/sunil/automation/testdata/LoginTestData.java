
package com.sunil.automation.testdata;

import org.testng.annotations.DataProvider;

public class LoginTestData {

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {

        return new Object[][] {

            {
                "invalid-user@example.invalid",
                "InvalidPassword123"
            },

            {
                "unknown-user@example.invalid",
                "Test@12345"
            },

            {
                "invalid-user@example.invalid",
                "WrongPassword456"
            }
        };
    }
}
