package nirmittandel_sec001_ex01;

import javafx.concurrent.Task;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField factorialInput;

    @FXML
    private TextField loanAmountInput;

    @FXML
    private TextField interestRateInput;

    @FXML
    private TextField durationInput;

    @FXML
    private TextField FactorialOutput;

    @FXML
    private TextField OutputInterest;

   
    @FXML
    private Label durationOutput;

    @FXML
    private Label interestOutput;

    @FXML
    private void calculateFactorial() {
        long number = Long.parseLong(factorialInput.getText());
        Task<Long> factorialTask = new FactorialTask(number);
        factorialTask.setOnSucceeded(e -> FactorialOutput.setText(factorialTask.getValue().toString()));
        new Thread(factorialTask).start();
    }

    @FXML
    private void calculateInterest() {
        double amount = Double.parseDouble(loanAmountInput.getText());
        double rate = Double.parseDouble(interestRateInput.getText());
        int duration = Integer.parseInt(durationInput.getText());
        Task<Double> carLoanTask = new CarLoanTask(amount, rate, duration);
        carLoanTask.setOnSucceeded(e -> {
            OutputInterest.setText(carLoanTask.getValue().toString());
        });
        new Thread(carLoanTask).start();
    }
}
