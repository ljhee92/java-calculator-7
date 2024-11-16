package calculator.model;

import java.util.Arrays;
import java.util.List;

public abstract class Delimiter {
    protected List<String> delimiters;
    protected String numeric;

    protected Delimiter(String input) {
        validateFormat(input);
        initialize(input);
    }

    protected abstract void validateFormat(String input);
    protected abstract void initialize(String input);

    public List<Integer> split() {
        delimiters.forEach(delimiter -> this.numeric = numeric.replace(delimiter, " "));

        return Arrays.stream(numeric.split(" "))
                .map(number -> number.isBlank() ? 0 : Integer.parseInt(number))
                .toList();
    }
}
