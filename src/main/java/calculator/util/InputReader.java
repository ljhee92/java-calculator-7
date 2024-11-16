package calculator.util;

import camp.nextstep.edu.missionutils.Console;

public interface InputReader {
    default String inputUserMessage() {
        return Console.readLine();
    }
}
