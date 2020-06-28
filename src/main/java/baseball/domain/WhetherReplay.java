package baseball.domain;

import java.util.Arrays;

public enum WhetherReplay {
    YES("1"), NO("2");

    private static final String INVALID_PLAYER_CHOICE_CODE_EXCEPTION_MESSAGE = "유효한 값이 아닙니다.";

    private final String chooseCode;

    WhetherReplay(final String chooseCode) {
        this.chooseCode = chooseCode;
    }

    public static WhetherReplay of(final String value) {
        return Arrays.stream(values())
            .filter(whetherReplayValue -> whetherReplayValue.chooseCode.equals(value))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(INVALID_PLAYER_CHOICE_CODE_EXCEPTION_MESSAGE));
    }

    public boolean isReplay() {
        return this == YES;
    }
}
