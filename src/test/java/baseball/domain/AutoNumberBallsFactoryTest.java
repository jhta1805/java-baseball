package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutoNumberBallsFactoryTest {
    @DisplayName("숫자목록 자동 생성시 예외 발생 없이 숫자목록 객체가 정상 생성 된다.")
    @Test
    void generatingTest() {
        NumberBallsFactory numberBallsFactory = new AutoNumberBallsFactory();
        assertThatCode(() -> generateNumberByAuto(numberBallsFactory, 500)).doesNotThrowAnyException();
    }

    private void generateNumberByAuto(NumberBallsFactory numberBallsFactory, int times) {
        for (int i = 0; i < times; i++) {
            numberBallsFactory.generateBalls();
        }
    }
}