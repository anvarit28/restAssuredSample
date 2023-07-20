# Sample API Testing Framework

![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)

This is a sample API testing framework built using RestAssured, Java, TestNG, and Maven. The framework provides a structured and scalable way to automate API tests, making it easier to write and maintain test cases.

## Features

- **RestAssured:** A powerful library for RESTful API testing in Java, allowing easy API request and response handling.
- **Java:** The programming language used to write the test scripts.
- **TestNG:** The testing framework for organizing and executing API test cases with annotations.
- **Maven:** A build automation tool to manage dependencies and build the project.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [How to Use](#how-to-use)
- [Writing Test Cases](#writing-test-cases)
- [Test Data and Environment Configuration](#test-data-and-environment-configuration)
- [Reporting](#reporting)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Getting Started

### Prerequisites

- Java JDK (version 8 or above) installed on your machine.
- Maven installed on your machine.

### Installation

1. Clone the repository:

```bash
git clone https://github.com/anvarit28/restAssuredSample.git
```

2. Navigate to the project directory:

```bash
cd restAssuredSample
```

3. Build the project:

```bash
mvn clean install
```

## How to Use

After successfully building the project, you can run the test cases using the following command:

```bash
mvn test -DsuiteXmlFile=configs/testng_user.xml

```

The tests will be executed using TestNG and RestAssured. TestNG generates test reports that can be found in the `target/surefire-reports` directory.

## Writing Test Cases

Test cases are written in Java and organized using TestNG annotations. You can find example test cases in the `src/test/java` directory.

Here's a basic example of a test case:

```java
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class APITest {

    @Test
    public void testGetUser() {
        // Perform API request
        given()
            .baseUri("https://api.example.com")
        .when()
            .get("/users/123")
        .then()
            .statusCode(200);

        // Perform assertions on the response
        // assertEquals(response.getStatusCode(), 200);
        // assertEquals(response.getBody().jsonPath().getString("username"), "john_doe");
        // ...
    }
}
```

## Test Data and Environment Configuration

Test data and environment configuration can be managed in separate properties files or as part of the test scripts. Make sure to handle sensitive data securely and avoid hardcoding sensitive information like passwords or access tokens.

## Reporting

TestNG generates test reports that can be found in the `target/surefire-reports` directory. You can also use additional reporting libraries like ExtentReports or Allure to generate more detailed and interactive reports.

## Contributing

We welcome contributions to improve and expand the sample API testing framework. To contribute, please follow the guidelines in the [CONTRIBUTING.md](CONTRIBUTING.md) file.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

If you have any questions or want to reach out, you can contact us via:

- Email: anvr28@gmail.com
- GitHub: [@anvarit28](https://github.com/anvarit28)
