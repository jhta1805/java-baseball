package baseball.domain;

import java.util.Arrays;

public enum PlayerChoice {
    PLAY_AGAIN("1"), GAME_END("2");

    private static final String INVALID_PLAYER_CHOICE_CODE_EXCEPTION_MESSAGE = "유효한 값이 아닙니다.";

    private final String chooseCode;

    PlayerChoice(final String chooseCode) {
        this.chooseCode = chooseCode;
    }

    public static PlayerChoice of(final String value) {
        return Arrays.stream(values())
            .filter(playerChoiceValue -> playerChoiceValue.chooseCode.equals(value))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(INVALID_PLAYER_CHOICE_CODE_EXCEPTION_MESSAGE));
    }

    public boolean isPlayAgain() {
        return this == PLAY_AGAIN;
    }
}
