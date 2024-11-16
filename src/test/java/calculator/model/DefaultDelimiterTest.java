package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("기본 구분자 테스트")
public class DefaultDelimiterTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    @DisplayName("쉼표(,) 또는 콜론(:)을 가지고 있는 문자열인지 확인한다.")
    void containsCommaAndColon(String input) {
        assertThat(DefaultDelimiter.from(input)).isInstanceOf(DefaultDelimiter.class);
    }

    @ParameterizedTest
    @MethodSource("generateValues")
    @DisplayName("쉼표(,) 또는 콜론(:)을 기준으로 문자열을 구분하여 숫자로 반환하는지 확인한다.")
    void split(String input, List<Integer> expected) {
        DefaultDelimiter delimiter = DefaultDelimiter.from(input);
        assertThat(delimiter.split()).isEqualTo(expected);
    }

    static Stream<Arguments> generateValues() {
        return Stream.of(
                Arguments.of("1,2,3", List.of(1, 2, 3)),
                Arguments.of("1:2:3", List.of(1, 2, 3)),
                Arguments.of("1,2:3", List.of(1, 2, 3)),
                Arguments.of("1:2,3", List.of(1, 2, 3)),
                Arguments.of("1,2,3,4", List.of(1, 2, 3, 4)),
                Arguments.of("1:2:3:4", List.of(1, 2, 3, 4)),
                Arguments.of("1,2,3:4", List.of(1, 2, 3, 4)),
                Arguments.of("1,2:3:4", List.of(1, 2, 3, 4)),
                Arguments.of("1:2,3,4", List.of(1, 2, 3, 4)),
                Arguments.of("1:2:3,4", List.of(1, 2, 3, 4))
        );
    }
}
