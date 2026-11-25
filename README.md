
# E-Commerce Test Automation Framework


[![E-Commerce Automation Suite](https://github.com/sunilkumargopinathan4-ai/selenium-ecommerce-automation/actions/workflows/automation.yml/badge.svg)](https://github.com/sunilkumargopinathan4-ai/selenium-ecommerce-automation/actions/workflows/automation.yml)

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
| Tests Executed | 17 |
| UI Tests | 12 |
| API Tests | 5 |
| Passed | 17 |
| Failed | 0 |
| Errors | 0 |
| Skipped | 0 |
| Build Status | SUCCESS |
| Browser | Chrome |
| Execution Time | 139.2 seconds |

## Automated UI Test Scenarios

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
| TC_CHECKOUT_001 | Complete checkout and account cleanup | End-to-End | PASS |

## Automated API Test Scenarios

| Test ID | Method | Endpoint | Scenario | Status |
|---|---|---|---|---|
| TC_API_001 | GET | /api/productsList | Retrieve products | PASS |
| TC_API_002 | GET | /api/brandsList | Retrieve brands | PASS |
| TC_API_003 | POST | /api/searchProduct | Search product | PASS |
| TC_API_004 | POST | /api/searchProduct | Missing search parameter | PASS |
| TC_API_005 | POST | /api/verifyLogin | Invalid credentials | PASS |





## Allure Reporting

- Interactive test execution dashboard.
- Individual test results and execution duration.
- Failure classification and exception details.
- Automatic screenshot attachments for failed UI tests.
- Maven-based report generation.

Generate and view the report locally:

    mvn allure:serve

## Continuous Integration - GitHub Actions

The framework includes a GitHub Actions workflow
for automated cloud-based test execution.

Pipeline features:

- Automatic execution on pushes to the main branch.
- Manual workflow execution.
- Ubuntu 24.04 runner.
- Java 21 and Maven dependency caching.
- Headless Chrome execution.
- Selenium UI and REST Assured API tests.
- Automatic Allure report generation.
- Downloadable test reports and failure screenshots.


## Test Execution Results

Successfully verified on November 25, 2026.

| Execution Type | Total | Passed | Failed |
|---|---:|---:|---:|
| Local Execution | 17 | 17 | 0 |
| GitHub Actions | 17 | 17 | 0 |

- Selenium UI test executions: 12
- REST Assured API tests: 5
- Cloud test execution duration: 119.6 seconds
- Pass rate for verified execution: 100%
- Allure report generation: Successful
- CI artifact upload: Successful

The framework has been successfully executed
locally and on GitHub-hosted Ubuntu runners
using Java 21 and headless Chrome.

The public demo application may experience
intermittent server availability issues.
An application health check is included in
the CI pipeline to identify environment
availability problems before test execution.

## CI Execution Evidence

[View successful GitHub Actions execution](https://github.com/sunilkumargopinathan4-ai/selenium-ecommerce-automation/actions/runs/45616710687)

## Execution Evidence

### Successful GitHub Actions Execution

![GitHub Actions Success](docs/screenshots/github-actions-success.png)

All 17 test executions passed, with zero failures,
errors or skipped tests.


## Known Limitations

- The public demo website may experience server
  overload and intermittent availability issues.
- Screenshot capture requires an active browser session.
- Firefox and Edge execution are not yet verified.
- Headless execution currently supports Chrome.



## Automated Failure Handling

- Global TestNG listener using IInvokedMethodListener.
- Automatic screenshots for failed UI test methods.
- Reusable screenshot utility with unique filenames.
- Failure diagnostics including URL, page title and exception.
- Separate handling for UI and API failures.
- Dedicated intentional failure probe to verify screenshot capture.

The failure probe is excluded from normal regression execution.


## API Automation Features

- REST Assured integration with TestNG.
- Centralized API request configuration.
- GET and POST request automation.
- HTTP status and JSON response code validation.
- JSON response extraction using JsonPath.
- Positive and negative API scenarios.
- Independent API execution without browser initialization.



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
