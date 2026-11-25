
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
| Tests Executed | 11 |
| Passed | 11 |
| Failed | 0 |
| Errors | 0 |
| Skipped | 0 |
| Build Status | SUCCESS |
| Browser | Chrome |
| Execution Time | 125.2 seconds |

## Automated Test Scenarios

| Test ID | Scenario | Type | Status |
|---|---|---|---|
| TC_HOME_001 | Homepage title verification | Smoke | PASS |
| TC_LOGIN_001 | Login page navigation | Functional | PASS |
| TC_LOGIN_002 | Invalid login - Dataset 1 | Data-driven | PASS |
| TC_LOGIN_003 | Invalid login - Dataset 2 | Data-driven | PASS |
| TC_LOGIN_004 | Invalid login - Dataset 3 | Data-driven | PASS |
| TC_REG_001 | Registration and account deletion | End-to-End | PASS |
| TC_AUTH_001 | Valid login and logout | End-to-End | PASS |
| TC_PROD_001 | All Products page validation | Functional | PASS |
| TC_PROD_002 | Product search validation | Functional | PASS |
| TC_CART_001 | Cart quantity, price and total validation | Functional | PASS |
| TC_CART_002 | Product removal and empty cart validation | Functional | PASS |



## Framework Reliability Enhancements

- Data-driven testing using TestNG DataProvider.
- Centralized Chrome advertisement blocking using CDP.
- Diagnostic screenshots for element timeouts and intercepted clicks.
- Failure diagnostics including locator, current URL and page title.





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
