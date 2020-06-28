package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberBallTest {
    @DisplayName("1-9 범위의 숫자를 입력받아 캐싱된 Ball객체를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void create_test(int value) {
        assertThatCode(() -> NumberBall.of(value)).doesNotThrowAnyException();
    }

    @DisplayName("1-9 바깥 범위의 Ball 객체 획득 시도시, IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void create_test_out_of_bound_exception(int invalidValue) {
        assertThatThrownBy(() -> NumberBall.of(invalidValue))
            .isInstanceOf(IllegalArgumentException.class);
    }
}