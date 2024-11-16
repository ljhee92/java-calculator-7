package calculator;

public class Calculator {
    private static Calculator calculator;

    private Calculator() {}

    public static Calculator getInstance() {
        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    public int plus(Numbers numbers) {
        return numbers.getNumbers().stream().mapToInt(number -> number).sum();
    }
}
