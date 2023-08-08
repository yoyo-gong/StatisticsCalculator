/**
 * The {@code StatisticsCalculatorServiceImpl} class implements the {@link StatisticsCalculatorService} interface and
 * provides the service layer for performing statistical calculations based on user input.
 */

import java.util.Arrays;

public class StatisticsCalculatorServiceImpl implements StatisticsCalculatorService {
    private StatisticsCalculator calculator;

    public StatisticsCalculatorServiceImpl() {
        this.calculator = new StatisticsCalculator();
    }

    @Override
    public String calculateStatistics(String inputData) {
        inputData = inputData.trim();

        if (inputData.isEmpty()) {
            return "Error: Input data is empty.";
        }
        System.out.println("Input data received in service: " + inputData);

        double[] data;

        try {
            data = Arrays.stream(inputData.split(","))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
        } catch (NumberFormatException e) {
            return "Error: Invalid input data. Please provide numeric values separated by commas.";
        }

        if (data.length == 0) {
            return "Error: Input data is empty.";
        }

        StringBuilder result = new StringBuilder();
        result.append("Statistical Results:\n");
        result.append("Count: ").append(StatisticsCalculator.calculateCount(data)).append("\n");
        result.append("Mean: ").append(String.format("%.2f", StatisticsCalculator.calculateMean(data))).append("\n");
        result.append("Standard Deviation: ").append(String.format("%.2f", StatisticsCalculator.calculateStandardDeviation(data))).append("\n");
        result.append("Minimum: ").append(String.format("%.2f", StatisticsCalculator.calculateMinimum(data))).append("\n");
        result.append("Maximum: ").append(String.format("%.2f", StatisticsCalculator.calculateMaximum(data))).append("\n");

        // Perform t-test for the given data
        double tValue = StatisticsCalculator.calculateTValue(data, data); // Using the same data for both samples
        double pValue = StatisticsCalculator.calculatePValue(tValue, data.length + data.length - 2);

        result.append("T-Value: ").append(String.format("%.2f", tValue)).append("\n");
        result.append("P-Value: ").append(String.format("%.4f", pValue)).append("\n");

        return result.toString();
    }
}
