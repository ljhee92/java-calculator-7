package calculator.controller;

import calculator.model.Calculator;
import calculator.model.Delimiter;
import calculator.model.Numbers;
import calculator.service.DelimiterService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final DelimiterService delimiterService;

    public CalculatorController(InputView inputView, OutputView outputView, DelimiterService delimiterService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.delimiterService = delimiterService;
    }

    public void run() {
        String input = inputView.requestInput();

        Delimiter delimiter = delimiterService.getDelimiter(input);
        Numbers numbers = Numbers.from(delimiter.split());

        int result = Calculator.getInstance().plus(numbers);
        outputView.displayResult(result);
    }
}
