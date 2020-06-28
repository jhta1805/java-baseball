package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberBallsTest {
    private NumberBall numberOne;
    private NumberBall numberTwo;
    private NumberBall numberThree;

    @BeforeEach
    void setUp() {
        numberOne = NumberBall.of(1);
        numberTwo = NumberBall.of(2);
        numberThree = NumberBall.of(3);
    }

    @DisplayName("중복이 없고, NumberBall를 3개 입력 받는 경우 NumberBalls 생성이 된다.")
    @Test
    void create_test() {
        assertThatCode(() -> new NumberBalls(Lists.list(numberOne, numberTwo, numberThree)))
            .doesNotThrowAnyException();
    }

    @DisplayName("숫자 목록 생성시 중복된 숫자객체가 포함되어 있는 경우 IllegalArgumentException 발생")
    @Test
    void create_exception_when_contains_duplicate_number() {
        NumberBall sameBallWithFirstBall = numberOne;
        assertThatThrownBy(() -> new NumberBalls(Lists.list(numberOne, numberTwo, sameBallWithFirstBall)))
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

    @DisplayName("두 숫자 목록을 비교후, 게임 룰에 따른 결과 객체를 반환.")
    @ParameterizedTest
    @MethodSource("getPlayerBallsAndResultSet")
    void compute_baseball_result(NumberBalls playerBalls, Result gameResult) {
        NumberBalls computerBalls = new NumberBalls(Lists.list(numberOne, numberTwo, numberThree));
        assertThat(computerBalls.compute(playerBalls)).isEqualTo(gameResult);
    }

    private static Stream<Arguments> getPlayerBallsAndResultSet() {
        NumberBall one = NumberBall.of(1);
        NumberBall two = NumberBall.of(2);
        NumberBall three = NumberBall.of(3);
        NumberBall four = NumberBall.of(4);
        NumberBall five = NumberBall.of(5);
        NumberBall six = NumberBall.of(6);

        return Stream.of(
            Arguments.of(new NumberBalls(Lists.list(one, two, three)), Result.of(3, 0)),
            Arguments.of(new NumberBalls(Lists.list(one, four, three)), Result.of(2, 0)),
            Arguments.of(new NumberBalls(Lists.list(five, two, six)), Result.of(1, 0)),
            Arguments.of(new NumberBalls(Lists.list(five, four, six)), Result.of(0, 0)),
            Arguments.of(new NumberBalls(Lists.list(one, five, two)), Result.of(1, 1)),
            Arguments.of(new NumberBalls(Lists.list(five, three, six)), Result.of(0, 1)),
            Arguments.of(new NumberBalls(Lists.list(two, one, three)), Result.of(1, 2)),
            Arguments.of(new NumberBalls(Lists.list(three, four, two)), Result.of(0, 2)),
            Arguments.of(new NumberBalls(Lists.list(three, one, two)), Result.of(0, 3))
        );
    }
}