package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBallsTest {
    @DisplayName("중복이 없고, NumberBall를 3개 입력 받는 경우 NumberBalls 생성이 된다.")
    @Test
    void create_test() {
        NumberBall firstNumber = NumberBall.of(1);
        NumberBall secondNumber = NumberBall.of(2);
        NumberBall thirdNumber = NumberBall.of(3);
        assertThatCode(() -> new NumberBalls(Lists.list(firstNumber, secondNumber, thirdNumber)))
            .doesNotThrowAnyException();
    }

    @DisplayName("숫자 목록 생성시 중복된 숫자객체가 포함되어 있는 경우 IllegalArgumentException 발생")
    @Test
    void create_exception_when_contains_duplicate_number() {
        NumberBall firstNumber = NumberBall.of(1);
        NumberBall secondNumber = NumberBall.of(2);
        NumberBall thirdNumber = NumberBall.of(1);
        assertThatThrownBy(() -> new NumberBalls(Lists.list(firstNumber, secondNumber, thirdNumber)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 목록 생성시 숫자객체의 size가 유효하지 않는 경우 (3이 아닌경우) IllegalArgumentException 발생")
    @Test
    void create_exception_when_balls_size_is_invalid() {
        NumberBall firstNumber = NumberBall.of(1);
        NumberBall secondNumber = NumberBall.of(2);
        assertThatThrownBy(() -> new NumberBalls(Lists.list(firstNumber, secondNumber)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}