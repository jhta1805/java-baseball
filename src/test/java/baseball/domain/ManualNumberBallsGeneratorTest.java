package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ManualNumberBallsGeneratorTest {
    @DisplayName("중복이 없고 0이 포함되지 않은 세자리의 자연수를 숫자 목록 객체로 생성한다.")
    @Test
    void generateBalls_test() {
        NumberBallsGenerator numberBallsGenerator = new ManualNumberBallsFactory(321);
        assertThat(numberBallsGenerator.generateBalls())
            .isEqualTo(new NumberBalls(Lists.list(NumberBall.of(3), NumberBall.of(2), NumberBall.of(1))));
    }

    @DisplayName("중복값 포함 혹은 세자리가 아니거나 음수인경우 생성도중 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {333, 1234, 75, -152, -10})
    void generateBalls_test_fail(int value) {
        assertThatThrownBy(() -> {
            NumberBallsGenerator numberBallsGenerator = new ManualNumberBallsFactory(value);
            numberBallsGenerator.generateBalls();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}