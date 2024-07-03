// CarLoanTask.java
package nirmittandel_sec001_ex01;

import javafx.concurrent.Task;

public class CarLoanTask extends Task<Double> {
    private double amount;
    private double rate;
    private int duration;

    public CarLoanTask(double amount, double rate, int duration) {
        this.amount = amount;
        this.rate = rate;
        this.duration = duration;
    }

    @Override
    protected Double call() throws Exception {
        return calculateInterest(amount, rate, duration);
    }

    private double calculateInterest(double amount, double rate, int duration) {
        return (amount * rate * duration) / 100;
    }
}
