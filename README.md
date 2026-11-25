
# E-Commerce Test Automation Framework

An independent web automation framework built using Java,
Selenium WebDriver, TestNG, Maven and Page Object Model.

## Project Overview

This project demonstrates the design and development of a
reusable, maintainable and configurable test automation
framework for an e-commerce application.

Application Under Test:
https://automationexercise.com/

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming Language |
| Selenium WebDriver | Web Automation |
| TestNG | Test Execution and Assertions |
| Maven | Dependency and Build Management |
| Page Object Model | Framework Design Pattern |
| Git and GitHub | Version Control |
| Eclipse | Development Environment |

## Implemented Features

- Reusable browser initialization and cleanup
- DriverFactory for browser selection
- Externalized configuration management
- Page Object Model architecture
- Reusable explicit wait methods
- Homepage smoke test
- TestNG assertions
- Maven-based test execution
- Configurable browser driver location

## Framework Architecture

```text
selenium-ecommerce-automation/
├── src/main/java/
│   └── com.sunil.automation/
│       ├── config/
│       │   └── ConfigReader.java
│       ├── factory/
│       │   └── DriverFactory.java
│       └── pages/
│           ├── BasePage.java
│           └── HomePage.java
├── src/test/java/
│   └── com.sunil.automation/
│       ├── base/
│       │   └── BaseTest.java
│       └── tests/
│           └── HomePageTest.java
├── src/test/resources/
│   └── config.properties
├── .gitignore
├── pom.xml
└── README.md
```

## Prerequisites

- Java JDK 21 or compatible newer JDK
- Apache Maven
- Google Chrome
- Git

## Test Execution

Clone the repository:

```bash
git clone https://github.com/sunilkumargopinathan4-ai/selenium-ecommerce-automation.git
cd selenium-ecommerce-automation
```

Execute the tests:

```bash
mvn clean test
```

For environments requiring a manually configured ChromeDriver:

```bash
mvn clean test "-Dwebdriver.chrome.driver=PATH_TO_CHROMEDRIVER"
```

## Latest Verified Test Result

| Metric | Result |
|---|---|
| Tests Executed | 1 |
| Passed | 1 |
| Failed | 0 |
| Skipped | 0 |
| Build Status | SUCCESS |
| Browser | Chrome |

## Troubleshooting Experience

During framework development, the following issues were
identified and investigated:

- Java package structure and compilation errors
- Selenium Manager blocked by Windows Application Control
- ChromeDriver configuration through Maven system properties
- Application availability failure (HTTP 522)

These issues helped strengthen practical automation
debugging and failure analysis skills.

## Development Roadmap

- [x] Maven project setup
- [x] Selenium and TestNG integration
- [x] Browser initialization and cleanup
- [x] DriverFactory implementation
- [x] Configuration management
- [x] Page Object Model foundation
- [x] Homepage smoke test
- [ ] Login automation
- [ ] Registration automation
- [ ] Product search automation
- [ ] Shopping cart validation
- [ ] Checkout workflows
- [ ] Data-driven testing
- [ ] Cross-browser execution verification
- [ ] REST Assured API automation
- [ ] Screenshots on failure
- [ ] Allure reporting
- [ ] GitHub Actions CI/CD

## Author

**Sunil Kumar G**

QA Automation Engineer | Mobile and API Testing |
Software Quality Engineering

[Connect on LinkedIn](https://www.linkedin.com/in/sunilkumarg01217/)

---

This is an independent portfolio project developed for
learning and demonstrating software test automation skills.
