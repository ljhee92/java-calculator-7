package calculator.model;

import calculator.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        validateRange(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static Numbers from(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 0)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_CALCULATE_POSITIVE_NUMBERS.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
