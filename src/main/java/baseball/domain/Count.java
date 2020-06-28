package baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Count {
    private static final int MIN_COUNT_VALUE = 0;
    private static final int MAX_COUNT_VALUE = NumberBalls.BALL_NUMBER_LENGTH;
    private static final Map<Integer, Count> COUNT_CACHE;

    private static final String INVALID_COUNT_VALUE_BOUNDARY_EXCEPTION_MESSAGE = "볼, 스트라이크수를 계산할 수 있는 유효한 값의 범위가 아닙니다.";

    static {
        COUNT_CACHE = new HashMap<>();
        for (int i = MIN_COUNT_VALUE; i <= MAX_COUNT_VALUE; i++) {
            COUNT_CACHE.put(i, new Count(i));
        }
    }

    private final int value;

    private Count(final int value) {
        verifyCountValue(value);
        this.value = value;
    }

    private void verifyCountValue(final int value) {
        if (value < MIN_COUNT_VALUE || value > MAX_COUNT_VALUE) {
            throw new IllegalArgumentException(INVALID_COUNT_VALUE_BOUNDARY_EXCEPTION_MESSAGE);
        }
    }

    public static Count of(final int value) {
        if (COUNT_CACHE.containsKey(value)) {
            return COUNT_CACHE.get(value);
        }
        throw new IllegalArgumentException(INVALID_COUNT_VALUE_BOUNDARY_EXCEPTION_MESSAGE);
    }

    public boolean isSameValue(final int countValue) {
        return this.value == countValue;
    }

    public boolean isSumOfValueGreaterThanMax(final Count otherCount) {
        return (this.value + otherCount.value) > NumberBalls.BALL_NUMBER_LENGTH;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Count count1 = (Count)o;
        return value == count1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
