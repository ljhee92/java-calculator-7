package calculator.model;

import calculator.constant.Delimiters;
import calculator.constant.ErrorMessage;

import java.util.List;

public class DefaultDelimiter extends Delimiter {
    private DefaultDelimiter(String input) {
        super(input);
    }

    public static DefaultDelimiter from(String input) {
        return new DefaultDelimiter(input);
    }

    @Override
    protected void validateFormat(String input) {
        if (!(input.contains(Delimiters.DEFAULT_COMMA.getDelimiter())
                || input.contains(Delimiters.DEFAULT_COLON.getDelimiter()))) {
            throw new IllegalArgumentException(ErrorMessage.DEFAULT_DELIMITER_IS_COMMA_OR_COLON.getMessage());
        }
    }

    @Override
    protected void initialize(String input) {
        setDelimiters();
        setNumeric(input);
    }

    private void setDelimiters() {
        this.delimiters = List.of(Delimiters.DEFAULT_COMMA.getDelimiter(), Delimiters.DEFAULT_COLON.getDelimiter());
    }

    private void setNumeric(String input) {
        this.numeric = input;
    }
}
