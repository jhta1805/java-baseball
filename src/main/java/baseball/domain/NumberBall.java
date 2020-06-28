package baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NumberBall {
    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 9;
    private static final String OUT_OF_BOUND_BALL_NUMBER_EXCEPTION_MESSAGE = "주어진 범위 바깥의 볼은 사용할 수 없어요.";
    private static final Map<Integer, NumberBall> BALL_CACHE = new HashMap<>();

    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            BALL_CACHE.put(i, new NumberBall(i));
        }
    }

    private final int value;

    private NumberBall(int value) {
        this.value = value;
    }

    public static NumberBall of(int value) {
        if (BALL_CACHE.containsKey(value)) {
            return BALL_CACHE.get(value);
        }
        throw new IllegalArgumentException(OUT_OF_BOUND_BALL_NUMBER_EXCEPTION_MESSAGE);
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
