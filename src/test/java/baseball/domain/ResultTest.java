package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ResultTest {
    @DisplayName("스트라이크, 볼 카운트가 0~3 범위이고 두 카운트의 합이 3을 넘지 않는 경우 결과 객체 생성.")
    @ParameterizedTest
    @CsvSource(value = {"0, 0", "1, 2", "2, 1", "3, 0", "0, 3"})
    void createTest(int strikeCount, int ballCount) {
        assertThatCode(() -> new Result(strikeCount, ballCount))
            .doesNotThrowAnyException();
    }

    @DisplayName("스트라이크, 볼 카운트가 0~3 범위 밖이거나 두 카운트의 합이 3을 넘는 경우 결과 생성시 IllegalArgumentException 발생")
    @ParameterizedTest
    @CsvSource(value = {"-1, 0", "0, 4", "-1, 4", "1, 3"})
    void create_fail_when_invalid_count_include(int strikeCount, int ballCount) {
        assertThatThrownBy(() -> new Result(strikeCount, ballCount))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결과 객체가 풀 스트라이크 여부를 반환할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"3, true", "2, false"})
    void isAllStrikeTest(int strikeCount, boolean isAllStrike) {
        Result result = new Result(strikeCount, 0);
        assertThat(result.isAllStrike()).isEqualTo(isAllStrike);
    }
}