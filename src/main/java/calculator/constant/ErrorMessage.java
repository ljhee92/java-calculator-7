package calculator.constant;

public enum ErrorMessage {
    DEFAULT_DELIMITER_IS_COMMA_OR_COLON("기본 구분자는 쉼표 또는 콜론입니다."),
    INVALID_CUSTOM_DELIMITER_FORMAT("커스텀 구분자는 //과 \\n 사이에 입력해야 합니다."),
    CUSTOM_DELIMITER_MUST_FILL("커스텀 구분자는 공백일 수 없습니다."),
    NUMBERS_CANNOT_BE_CUSTOM_DELIMITER("커스텀 구분자는 숫자일 수 없습니다."),
    ONLY_CALCULATE_POSITIVE_NUMBERS("양수만 계산 가능합니다.")
    ;

    private static final String PREFIX = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
