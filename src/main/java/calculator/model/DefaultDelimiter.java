package calculator.model;

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
        if (!input.contains(",") && !input.contains(":")) {
            throw new IllegalArgumentException("기본 구분자는 쉼표 또는 콜론 가져야 함");
        }
    }

    @Override
    protected void initialize(String input) {
        setDelimiters();
        setNumeric(input);
    }

    private void setDelimiters() {
        this.delimiters = List.of(",", ":");
    }

    private void setNumeric(String input) {
        this.numeric = input;
    }
}
