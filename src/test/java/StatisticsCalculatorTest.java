import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatisticsCalculatorTest {

    @Test
    void testCalculateMean() {
        double[] data = {2, 4, 6, 8, 10};
        double expectedMean = 6.0;
        double actualMean = StatisticsCalculator.calculateMean(data);
        Assertions.assertEquals(expectedMean, actualMean);
    }

    @Test
    void testCalculateMedian() {
        double[] data = {2, 4, 6, 8, 10};
        double expectedMedian = 6.0;
        double actualMedian = StatisticsCalculator.calculateMedian(data);
        Assertions.assertEquals(expectedMedian, actualMedian);
    }

    @Test
    void testCalculateStandardDeviation() {
        double[] data = {2, 4, 6, 8, 10};
        double expectedStdDev = 2.8284271247461903;
        double actualStdDev = StatisticsCalculator.calculateStandardDeviation(data);
        Assertions.assertEquals(expectedStdDev, actualStdDev);
    }

    @Test
    void testCalculateMean_EmptyData() {
        double[] data = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> StatisticsCalculator.calculateMean(data));
    }

    @Test
    void testCalculateMedian_EmptyData() {
        double[] data = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> StatisticsCalculator.calculateMedian(data));
    }

    @Test
    void testCalculateStandardDeviation_EmptyData() {
        double[] data = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> StatisticsCalculator.calculateStandardDeviation(data));
    }
}
