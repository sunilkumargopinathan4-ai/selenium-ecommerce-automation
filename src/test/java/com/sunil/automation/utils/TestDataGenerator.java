
package com.sunil.automation.utils;

import java.util.UUID;

public class TestDataGenerator {

    public static String generateEmail() {
        return "qa_" + UUID.randomUUID()
                + "@example.com";
    }

    public static String generateName() {
        return "Automation Test User";
    }

    public static String generatePassword() {
        return "Demo@" + UUID.randomUUID()
                .toString().substring(0, 8) + "123";
    }
}
