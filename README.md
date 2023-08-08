# StatisticsCalculator
## Overview
The Statistics Calculator is a Java-based application that provides a graphical user interface (GUI) for performing various statistical calculations on a given set of numeric data. The program uses Swing for the GUI components and follows the principles of Clean Architecture and Dependency Injection to maintain a well-organized and maintainable codebase.

## Features
The Statistics Calculator offers the following features:

- Mean Calculation: Calculates the mean (average) of the input data.
- Median Calculation: Calculates the median of the input data.
- Standard Deviation Calculation: Calculates the standard deviation of the input data.
- Minimum and Maximum Calculation: Determines the minimum and maximum values in the input data.
- T-Test: Performs a two-sample t-test on two sets of sample data to calculate the t-value and p-value.
  
## Usage
- Input Data: Enter a list of numeric values separated by commas into the provided text field.
- Calculate: After entering the data, click the "Calculate" button to perform the statistical calculations.
- Results: The calculated statistics will be displayed in the output text area, including mean, median, standard deviation, minimum, maximum, t-value, and p-value.
  
## Class Hierarchy
The program consists of the following classes:

- Main: The main class is the entry point of the application, initializing the GUI and starting the program.
- StatisticsCalculator: This class contains methods to perform statistical calculations such as mean, median, standard deviation, and t-test.
- StatisticsCalculatorService: The interface defines the contract for the service layer to perform statistical calculations.
- StatisticsCalculatorServiceImpl: The class implements the StatisticsCalculatorService interface and provides the service layer for calculating statistics.
- StatisticsCalculatorSwingView: This class represents the Swing-based GUI for the Statistics Calculator program.
  
## Design Patterns
The program follows the principles of Clean Architecture, where the core business logic is separated from the external dependencies. It uses Dependency Injection to decouple the service layer from the GUI components, promoting modularity and testability.

## How to Run
To run the program, execute the Main class. The GUI window will appear, allowing you to enter numeric data and view the calculated statistics.

## Dependencies
The program uses Apache Commons Math library for the t-distribution calculations, adding robustness and accuracy to the t-test.

## Developer Notes
The Statistics Calculator program provides a user-friendly interface for conducting statistical analyses without the need for complex statistical software. It is designed to be easily extensible, allowing for the addition of new statistical calculations and features in the future.



