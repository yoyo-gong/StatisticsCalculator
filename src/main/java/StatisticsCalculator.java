/**
 * The {@code StatisticsCalculator} class provides methods to perform various statistical calculations on a given array of
 * numeric data.
 */


import org.apache.commons.math3.distribution.TDistribution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;

public class StatisticsCalculator {
    public static double calculateMean(double[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data is empty");
        }

        double sum = 0;
        for (double value : data) {
            sum += value;
        }

        return sum / data.length;
    }

    public static double calculateMedian(double[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data is empty");
        }

        Arrays.sort(data);

        int n = data.length;
        if (n % 2 == 0) {
            return (data[n / 2 - 1] + data[n / 2]) / 2.0;
        } else {
            return data[n / 2];
        }
    }

    public static double calculateStandardDeviation(double[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data is empty");
        }

        double mean = calculateMean(data);
        double sumOfSquaredDifferences = 0;

        for (double value : data) {
            sumOfSquaredDifferences += Math.pow(value - mean, 2);
        }

        double variance = sumOfSquaredDifferences / data.length;
        return Math.sqrt(variance);
    }

    public static int calculateCount(double[] data) {
        if (data == null) {
            return 0;
        }
        return data.length;
    }

    public static double calculateMinimum(double[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data is empty");
        }

        double min = data[0];
        for (double value : data) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    public static double calculateMaximum(double[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data is empty");
        }

        double max = data[0];
        for (double value : data) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    public static double calculateTValue(double[] data1, double[] data2) {
        if (data1 == null || data2 == null || data1.length == 0 || data2.length == 0) {
            throw new IllegalArgumentException("Input data is empty");
        }

        int n1 = data1.length;
        int n2 = data2.length;

        double mean1 = calculateMean(data1);
        double mean2 = calculateMean(data2);

        double sumOfSquaredDifferences1 = 0;
        double sumOfSquaredDifferences2 = 0;

        for (double value : data1) {
            sumOfSquaredDifferences1 += Math.pow(value - mean1, 2);
        }

        for (double value : data2) {
            sumOfSquaredDifferences2 += Math.pow(value - mean2, 2);
        }

        double pooledVariance = (sumOfSquaredDifferences1 + sumOfSquaredDifferences2) / (n1 + n2 - 2);

        double tValue = (mean1 - mean2) / Math.sqrt(pooledVariance * (1.0 / n1 + 1.0 / n2));
        return tValue;
    }

    public static double calculatePValue(double tValue, int degreesOfFreedom) {
        if (degreesOfFreedom <= 0) {
            throw new IllegalArgumentException("Degrees of freedom must be greater than 0");
        }

        TDistribution tDistribution = new TDistribution(degreesOfFreedom);
        double pValue = tDistribution.cumulativeProbability(-Math.abs(tValue)) * 2;
        return pValue;
    }

    private static double calculateVariance(double[] data) {
        double mean = calculateMean(data);
        double sumOfSquaredDifferences = 0;

        for (double value : data) {
            sumOfSquaredDifferences += Math.pow(value - mean, 2);
        }

        double variance = sumOfSquaredDifferences / (data.length - 1);
        return variance;
    }
}
