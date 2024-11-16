package calculator.service;

import calculator.model.CustomDelimiter;
import calculator.model.DefaultDelimiter;
import calculator.model.Delimiter;

public class DelimiterService {
    private Delimiter delimiter;

    public Delimiter getDelimiter(String input) {

        if (input.contains(",") || input.contains(":")) {
            delimiter = DefaultDelimiter.from(input);
        }

        if (input.startsWith("//")) {
            delimiter = CustomDelimiter.from(input);
        }

        return delimiter;
    }
}
