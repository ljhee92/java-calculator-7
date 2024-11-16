package calculator;

import java.util.List;

public class Calculator {
    private static Calculator calculator;

    private Calculator() {}

    public static Calculator getInstance() {
        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    public int plus(List<Integer> numbers) {
        return numbers.stream().mapToInt(number -> number).sum();
    }
}
