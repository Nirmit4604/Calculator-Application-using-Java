// FactorialTask.java
package nirmittandel_sec001_ex01;

import javafx.concurrent.Task;

public class FactorialTask extends Task<Long> {
    private long number;

    public FactorialTask(long number) {
        this.number = number;
    }

    @Override
    protected Long call() throws Exception {
        return calculateFactorial(number);
    }

    private long calculateFactorial(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        long result = 1;
        for (long i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
