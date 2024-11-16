package calculator.service;

import calculator.model.CustomDelimiter;
import calculator.model.DefaultDelimiter;
import calculator.model.Delimiter;
import calculator.model.NoneDelimiter;
import calculator.constant.Delimiters;

public class DelimiterService {
    public Delimiter getDelimiter(String input) {
        Delimiter delimiter = NoneDelimiter.from(input);

        if (input.contains(Delimiters.DEFAULT_COMMA.getDelimiter())
                || input.contains(Delimiters.DEFAULT_COLON.getDelimiter())) {
            delimiter = DefaultDelimiter.from(input);
        }

        if (input.startsWith(Delimiters.CUSTOM_START.getDelimiter())) {
            delimiter = CustomDelimiter.from(input);
        }

        return delimiter;
    }
}
