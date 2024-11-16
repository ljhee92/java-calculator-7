package calculator;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        DelimiterService delimiterService = new DelimiterService();

        CalculatorController calculatorController = new CalculatorController(inputView, outputView, delimiterService);
        calculatorController.run();
    }
}
