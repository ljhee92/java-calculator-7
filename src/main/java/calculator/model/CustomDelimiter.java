package calculator.model;

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
        if (!(input.startsWith("//") && input.contains("\\n"))) {
            throw new IllegalArgumentException("커스텀 구분자 형식 잘못 입력함");
        }
    }

    @Override
    protected void initialize(String input) {
        String customDelimiters = input.substring(0, input.indexOf("\\n")).replaceAll("//", "");

        if (customDelimiters.isBlank()) {
            throw new IllegalArgumentException("커스텀 구분자 입력 안 함");
        }

        if (customDelimiters.matches("[0-9]")) {
            throw new IllegalArgumentException("숫자는 안 됨");
        }

        setDelimiters(customDelimiters);
        setNumeric(input);
    }

    private void setDelimiters(String customDelimiter) {
        this.delimiters = Arrays.asList(customDelimiter.split(""));
    }

    private void setNumeric(String input) {
        this.numeric = input.substring(input.indexOf("\\n")).replace("\\n", "");
    }
}
