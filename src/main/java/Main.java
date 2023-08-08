/**
 * The Statistics Calculator program provides a graphical user interface (GUI) for performing various statistical
 * calculations on a given set of numeric data.
 * <p>
 * The main entry point for the program is the {@link Main} class, which initializes the GUI and starts the application.
 * The statistical calculations are performed by the {@link StatisticsCalculator} class, and the GUI is represented by the
 * {@link StatisticsCalculatorSwingView} class.
 * <p>
 * The core statistical calculations are encapsulated in the {@link StatisticsCalculator} class. This class provides methods
 * for calculating mean, median, standard deviation, minimum, and maximum from a given array of numeric data. Additionally,
 * it also calculates the t-value and p-value for a two-sample t-test when provided with two arrays of sample data.
 * <p>
 * The {@link StatisticsCalculatorServiceImpl} class acts as a service layer that uses the {@link StatisticsCalculator} class
 * to perform the statistical calculations. It receives input data from the GUI, processes it, and provides the results back
 * to the GUI for display.
 * <p>
 * The GUI is implemented using Swing components and is represented by the {@link StatisticsCalculatorSwingView} class.
 * Users can enter numeric data in a text field, and upon clicking the "Calculate" button, the statistical calculations
 * are performed, and the results are displayed in a text area on the GUI.
 */


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Instantiate the service and view
        StatisticsCalculatorService service = new StatisticsCalculatorServiceImpl();
        StatisticsCalculatorView view = new StatisticsCalculatorSwingView(service);

        // Set the view to be visible
        SwingUtilities.invokeLater(() -> ((JFrame) view).setVisible(true));
    }
}
