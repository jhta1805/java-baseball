package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PlayerChoiceTest {
    @DisplayName("1, 2 값 이외의 값을 입력받은 경우, IllegalArgumentException 발생")
    @Test
    void create_fail() {
        assertThatThrownBy(() -> PlayerChoice.of("3")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1을 넣는 경우, 게임 재시작 여부 true, 2를 넣는 경우, 게임 재시작 여부 false를 반환")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, false"})
    void playAgainTest(String inputValue, boolean expected) {
        PlayerChoice playerChoice = PlayerChoice.of(inputValue);
        assertThat(playerChoice.isPlayAgain()).isEqualTo(expected);
    }
}