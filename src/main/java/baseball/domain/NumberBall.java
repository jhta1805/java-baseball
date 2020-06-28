package baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class NumberBall {
    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 9;
    private static final Map<Integer, NumberBall> BALL_CACHE = new HashMap<>();

    private static final String INVALID_BALL_NUMBER_BOUNDARY_EXCEPTION_MESSAGE = "주어진 범위 바깥의 볼은 사용할 수 없어요.";

    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            BALL_CACHE.put(i, new NumberBall(i));
        }
    }

    private final int value;

    private NumberBall(final int value) {
        verifyNumberBall(value);
        this.value = value;
    }

    private void verifyNumberBall(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_BALL_NUMBER_BOUNDARY_EXCEPTION_MESSAGE);
        }
    }

    public static NumberBall of(final int value) {
        if (BALL_CACHE.containsKey(value)) {
            return BALL_CACHE.get(value);
        }
        throw new IllegalArgumentException(INVALID_BALL_NUMBER_BOUNDARY_EXCEPTION_MESSAGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NumberBall that = (NumberBall)o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
