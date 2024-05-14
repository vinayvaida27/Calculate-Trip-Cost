# Calculate Trip Cost

## Overview

This repository contains automation scripts and resources to calculate and analyze the cost of trips for holiday homes and cruises. The primary focus is on fetching and processing data related to travel accommodations and amenities, specifically targeted towards holiday homes in Nairobi and cruises by A-ROSA Cruises.

## Repository Structure

- **Jenkins**: Contains Jenkins configuration files for automating builds and tests.
- **Videos**: Stores video recordings of test executions.
- **failScreenshot**: Contains screenshots captured during failed test executions.
- **selenium_grid**: Holds configuration files for Selenium Grid, which allows for running tests on different machines and browsers simultaneously.
- **src**: Source code for the test scripts written in Java using Selenium WebDriver.
- **target**: Compiled test artifacts.
- **test-output**: Stores test execution reports including ExtentReports.
- **README.txt**: Basic text version of project documentation.
- **TripCostCalculator_manualTesting.xlsx**: Spreadsheet containing manual test cases and expected results.
- **pom.xml**: Maven Project Object Model file, which includes project and configuration details used by Maven.
- **proCon.properties**: Properties file for configuring project-specific settings.
- **testng.xml**: TestNG configuration files specifying the test suites and parameters.
- **testng1111.xml**: Additional TestNG configuration for specific testing scenarios.

## Features

- **Automated Test Execution**: Scripts to automatically fetch and analyze cost data for specified travel scenarios.
- **Sorting and Filtering**: Functionalities to sort and filter holiday homes based on ratings and amenities such as elevator access.
- **Cruise Line Analysis**: Scripts to fetch and display details about cruise ships, including available languages and operational details.

## Prerequisites

- Java JDK 1.8
- Selenium WebDriver 3.141.59
- TestNG 7.3.0
- Apache Maven 3.6.3
- Browsers: Chrome (90), Firefox (88), and Edge (90)

## How to Run

1. Clone the repository:
```bash
git clone https://github.com/vinayvaida27/Calculate-Trip-Cost.git
```
2. Navigate to the repository directory and run the tests using Maven:

```bash
cd Calculate-Trip-Cost
mvn clean test

```

## Reporting Bugs and Contributions

- To report bugs, please use the GitHub issues tab.
- To contribute to the project, please fork the repository, make your changes, and submit a pull request.

## Contact

For more information, please contact Vinay Vaida at [vinayvaida@gmail.com](mailto:vinayvaida@gmail.com) or connect with me on [LinkedIn](https://www.linkedin.com/in/vinayvaida/).

## License

This project is licensed under the MIT License - see the LICENSE.md file for details.

```bash

```
