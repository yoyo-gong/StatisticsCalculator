/**
 * The {@code StatisticsCalculatorView} interface defines the contract for the graphical user interface (GUI) of the
 * Statistics Calculator program. Implementing classes must provide methods for interacting with the GUI components
 * and displaying statistical results to the user.
 */

public interface StatisticsCalculatorView {
    void displayResult(String result);
    String getInputData();
    void clearInput();
}
