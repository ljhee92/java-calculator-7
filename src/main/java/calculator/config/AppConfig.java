package calculator.config;

import calculator.controller.CalculatorController;
import calculator.service.DelimiterService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {
    public CalculatorController calculatorController() {
        return new CalculatorController(inputView(), outputView(), delimiterService());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public DelimiterService delimiterService() {
        return new DelimiterService();
    }
}
