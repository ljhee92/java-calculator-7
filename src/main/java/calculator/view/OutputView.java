package calculator.view;

import calculator.util.OutputWriter;

public class OutputView implements OutputWriter {
    private static final String RESULT_IS = "결과 : ";
    
    public void displayResult(int result) {
        displayMessage(RESULT_IS + result);
    }
}
