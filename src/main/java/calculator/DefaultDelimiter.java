package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultDelimiter {
    private final String input;

    private DefaultDelimiter(String input) {
        containsCommaAndColon(input);
        this.input = input;
    }

    public static DefaultDelimiter from(String input) {
        return new DefaultDelimiter(input);
    }

    private void containsCommaAndColon(String input) {
        if (!input.contains(",") && !input.contains(":")) {
            throw new IllegalArgumentException("쉼표 또는 콜론 가지고 있지 않음");
        }
    }

    public List<Integer> split() {
        if (input.contains(",") && !input.contains(":")) {
            return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).boxed().toList();
        }

        if (input.contains(":") && !input.contains(",")) {
            return Arrays.stream(input.split(":")).mapToInt(Integer::parseInt).boxed().toList();
        }

        String[] splitByComma = input.split(",");
        List<Integer> result = new ArrayList<>();
        for (String splittedString : splitByComma) {
            if (splittedString.contains(":")) {
                String[] splitByColon = splittedString.split(":");
                Arrays.stream(splitByColon).forEach(string -> result.add(Integer.parseInt(string)));
                continue;
            }
            result.add(Integer.parseInt(splittedString));
        }
        return result;
    }
}
