package calculator.view;

import calculator.util.InputReader;
import calculator.util.OutputWriter;

public class InputView implements InputReader, OutputWriter {
    private static final String REQUEST_INPUT_FOR_PLUS = "덧셈할 문자열을 입력해 주세요.";

    public String requestInput() {
        displayMessage(REQUEST_INPUT_FOR_PLUS);
        return inputUserMessage();
    }
}
