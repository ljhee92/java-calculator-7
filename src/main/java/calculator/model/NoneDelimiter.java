package calculator.model;

import java.util.List;

public class NoneDelimiter extends Delimiter {
    private NoneDelimiter(String input) {
        super(input);
    }

    public static NoneDelimiter from(String input) {
        return new NoneDelimiter(input);
    }

    @Override
    protected void validateFormat(String input) {
    }

    @Override
    protected void initialize(String input) {
        this.delimiters = List.of(" ");
        this.numeric = input;
    }
}
