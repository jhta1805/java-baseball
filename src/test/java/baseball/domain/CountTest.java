package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CountTest {
    @DisplayName("스트라이크 혹은 볼의 최소, 최대 가능 갯수를 인자로 count 객체 생성시 정상적으로 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void create_test(int count) {
        assertThatCode(() -> Count.of(count)).doesNotThrowAnyException();
    }

    @DisplayName("스트라이크 혹은 볼의 갯수로 가능하지 않는 값을 인자로 count 객체 생성시 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void create_test_fail(int count) {
        assertThatThrownBy(() -> Count.of(count)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("count 객체가 인자값에 해당하는 값을 가지고 있으면 true, 그렇지 않으면 false 반환")
    @ParameterizedTest
    @CsvSource(value = {"3, 3, true", "2, 3, false"})
    void isSameValueTest(int countValue, int comparer, boolean expected) {
        Count count = Count.of(countValue);
        assertThat(count.isSameValue(comparer)).isEqualTo(expected);
    }

    @DisplayName("두 count객체의 value의 값의 합이 숫자의 자릿수를 넘으면 true, 넘지 않으면 false 반환")
    @ParameterizedTest
    @CsvSource(value = {"3, 3, true", "0, 3, false", "1, 2, false", "0, 0, false"})
    void isSumOfValueGreaterThanMax(int firstValue, int secondValue, boolean expected) {
        Count firstCount = Count.of(firstValue);
        Count secondCount = Count.of(secondValue);
        assertThat(firstCount.isSumOfValueGreaterThanMax(secondCount)).isEqualTo(expected);
    }
}