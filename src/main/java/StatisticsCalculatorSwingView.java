/**
 * The {@code StatisticsCalculatorSwingView} class represents the graphical user interface (GUI) for the Statistics
 * Calculator program, allowing users to enter numeric data and view the statistical results.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsCalculatorSwingView extends JFrame implements StatisticsCalculatorView {
    private JTextField dataField;
    private JTextArea outputArea;
    private JButton calculateButton;
    private StatisticsCalculatorService service;

    public StatisticsCalculatorSwingView(StatisticsCalculatorService service) {
        this.service = service;
        // Initialize the frame and components here
        setTitle("Statistics Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        dataField = new JTextField();
        outputArea = new JTextArea();
        calculateButton = new JButton("Calculate");

        // Add components to the frame
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Input Data (comma-separated):"), BorderLayout.NORTH);
        inputPanel.add(dataField, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);

        // Add action listener for the Calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputData = dataField.getText();
                System.out.println("Input data retrieved from GUI: " + inputData);
                String result = service.calculateStatistics(inputData);
                outputArea.setText(result);
            }
        });
    }

    @Override
    public void displayResult(String result) {
        outputArea.setText(result);
    }

    @Override
    public String getInputData() {
        return dataField.getText();
    }

    @Override
    public void clearInput() {
        dataField.setText("");
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }
}