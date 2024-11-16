package calculator.constant;

public enum Delimiters {
    NONE(" "),
    DEFAULT_COMMA(","),
    DEFAULT_COLON(":"),
    CUSTOM_START("//"),
    CUSTOM_END("\\n")
    ;

    private final String delimiter;

    Delimiters(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
