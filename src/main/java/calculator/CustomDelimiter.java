package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomDelimiter {
    private List<String> delimiters;
    private String numeric;

    private CustomDelimiter(String input) {
        validateFormat(input);
        containsCustomDelimiter(input);
        containsCustomDelimiterInNumeric(input);
    }

    public static CustomDelimiter from(String input) {
        return new CustomDelimiter(input);
    }

    private void validateFormat(String input) {
        if (!(input.startsWith("//") && input.contains("\\n"))) {
            throw new IllegalArgumentException("커스텀 구분자 형식 잘못 입력함");
        }
    }

    private void containsCustomDelimiter(String input) {
        String customDelimiter = input.substring(0, input.indexOf("\\n")).replaceAll("//", "");

        if (customDelimiter.isBlank()) {
            throw new IllegalArgumentException("커스텀 구분자 입력 안 함");
        }

        this.delimiters = Arrays.asList(customDelimiter.split(""));
    }

    private void containsCustomDelimiterInNumeric(String input) {
        this.numeric = input.substring(input.indexOf("\\n")).replace("\\n", "");
        System.out.println(numeric);

        if (!(delimiters.stream().allMatch(numeric::contains))) {
            throw new IllegalArgumentException("계산식에 커스텀 구분자 포함 안 됨");
        }
    }

    public List<Integer> split() {
        delimiters.forEach(delimiter -> this.numeric = numeric.replace(delimiter, " "));

        return Arrays.stream(numeric.split(" ")).mapToInt(Integer::parseInt).boxed().toList();
    }
}
