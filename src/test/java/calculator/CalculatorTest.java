package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("계산기 테스트")
public class CalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3 - 6", "1:2:3 - 6", "1,2:3 - 6", "1:2,3 - 6",
            "1,2,3,4 - 10", "1:2:3:4 - 10", "1,2:3:4 - 10", "1:2:3,4 - 10"},
            delimiter = '-')
    @DisplayName("쉼표(,)와 콜론(:)을 기준으로 구분하여 반환한 문자열을 모두 더한 값과 기대값이 동일한지 확인한다.")
    void plusByDefaultDelimiter(String input, int expected) {
        DefaultDelimiter delimiter = DefaultDelimiter.from(input);
        Numbers numbers = Numbers.from(delimiter.split());

        assertThat(Calculator.getInstance().plus(numbers)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"//!\\n1!2 - 3", "//@!\\n1@2!3 - 6", "//,:\\n1,2:3 - 6"},
            delimiter = '-')
    @DisplayName("커스텀 구분자를 기준으로 구분하여 반환한 문자열을 모두 더한 값과 기대값이 동일한지 확인한다.")
    void plusByCustomDelimiter(String input, int expected) {
        CustomDelimiter delimiter = CustomDelimiter.from(input);
        Numbers numbers = Numbers.from(delimiter.split());

        assertThat(Calculator.getInstance().plus(numbers)).isEqualTo(expected);
    }
}
