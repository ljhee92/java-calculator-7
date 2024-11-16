package calculator.service;

import calculator.model.CustomDelimiter;
import calculator.model.DefaultDelimiter;
import calculator.model.Delimiter;
import calculator.model.NoneDelimiter;

public class DelimiterService {
    public Delimiter getDelimiter(String input) {
        Delimiter delimiter = NoneDelimiter.from(input);

        if (input.contains(",") || input.contains(":")) {
            delimiter = DefaultDelimiter.from(input);
        }

        if (input.startsWith("//")) {
            delimiter = CustomDelimiter.from(input);
        }

        return delimiter;
    }
}
