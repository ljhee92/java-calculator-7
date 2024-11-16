package calculator.model;

import calculator.constant.Delimiters;
import calculator.constant.ErrorMessage;

import java.util.Arrays;

public class CustomDelimiter extends Delimiter {
    private CustomDelimiter(String input) {
        super(input);
    }

    public static CustomDelimiter from(String input) {
        return new CustomDelimiter(input);
    }

    @Override
    protected void validateFormat(String input) {
        if (!(input.startsWith(Delimiters.CUSTOM_START.getDelimiter())
                && input.contains(Delimiters.CUSTOM_END.getDelimiter()))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER_FORMAT.getMessage());
        }
    }

    @Override
    protected void initialize(String input) {
        String customDelimiters = input.substring(0, input.indexOf(Delimiters.CUSTOM_END.getDelimiter()))
                .replaceAll(Delimiters.CUSTOM_START.getDelimiter(), "");

        validateCustomDelimiters(customDelimiters);

        setDelimiters(customDelimiters);
        setNumeric(input);
    }

    private void validateCustomDelimiters(String customDelimiters) {
        if (customDelimiters.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.CUSTOM_DELIMITER_MUST_FILL.getMessage());
        }

        if (customDelimiters.matches("[0-9]")) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_CANNOT_BE_CUSTOM_DELIMITER.getMessage());
        }
    }

    private void setDelimiters(String customDelimiter) {
        this.delimiters = Arrays.asList(customDelimiter.split(""));
    }

    private void setNumeric(String input) {
        this.numeric = input.substring(input.indexOf(Delimiters.CUSTOM_END.getDelimiter()))
                .replace(Delimiters.CUSTOM_END.getDelimiter(), "");
    }
}
