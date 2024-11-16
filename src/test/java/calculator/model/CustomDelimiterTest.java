package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("커스텀 구분자 테스트")
public class CustomDelimiterTest {
    @ParameterizedTest
    @ValueSource(strings = {"//!\\n1!2", "//@!\\n1@2!3", "//,:\\n1,2:3"})
    @DisplayName("문자열 앞부분에 //와 \\n을 가지고 있는지, 그 사이에 커스텀 구분자가 있는지, 계산식에 커스텀 구분자가 있는지 확인한다.")
    void validateFormat(String input) {
        assertThat(CustomDelimiter.from(input)).isInstanceOf(CustomDelimiter.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"!\\n1!2", "//!1!2!3", "//\\n123", "//0\\n10203"})
    @DisplayName("커스텀 구분자의 형식이 올바르지 않다면 예외가 발생한다.")
    void invalidCustomDelimiterFormat(String input) {
        assertThatThrownBy(() -> {
            CustomDelimiter.from(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{index} : {2}")
    @MethodSource("generateValues")
    @DisplayName("커스텀 구분자를 기준으로 문자열을 구분하여 숫자로 반환하는지 확인한다.")
    void split(String input, List<Integer> expected, String message) {
        CustomDelimiter delimiter = CustomDelimiter.from(input);
        assertThat(delimiter.split()).isEqualTo(expected);
    }

    static Stream<Arguments> generateValues() {
        return Stream.of(
                Arguments.of("//!\\n1!2", List.of(1, 2), "! 하나일 때"),
                Arguments.of("//@!\\n1@2!3", List.of(1, 2, 3), "@, ! 두 개일 때"),
                Arguments.of("//,:\\n1,2:3", List.of(1, 2, 3), "기본 구분자일 때"),
                Arguments.of("//!\\n1!!2!3", List.of(1, 0, 2, 3), "커스텀 구분자 중복사용할 때")
        );
    }
}
