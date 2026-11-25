
package com.sunil.automation.config;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new IllegalStateException(
                        "config.properties file not found");
            }

            properties.load(input);

        } catch (IOException e) {

            throw new IllegalStateException(
                    "Failed to load configuration file", e);
        }
    }

    public static String getProperty(String key) {

        String value = System.getProperty(key,
                properties.getProperty(key));

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Missing configuration property: " + key);
        }

        return value;
    }
}
