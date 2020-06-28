package baseball.domain;

import java.util.Objects;

public final class Result {
    private static final String INVALID_TOTAL_COUNT_OF_STRIKE_BALL_EXCEPTION_MESSAGE =
        "스트라이크와 볼의 값의 합이 현재 가능한 값을 넘었습니다.";
    private static final String NULL_COUNT_EXCEPTION_MESSAGE = "NULL값이 들어갈 수 없습니다.";

    private final Count strike;
    private final Count ball;

    private Result(final Count strike, final Count ball) {
        verifyCounts(strike, ball);
        this.strike = strike;
        this.ball = ball;
    }

    private void verifyCounts(final Count strikeCount, final Count ballCount) {
        if (Objects.isNull(strikeCount) || Objects.isNull(ballCount)) {
            throw new IllegalArgumentException(NULL_COUNT_EXCEPTION_MESSAGE);
        }
        if (strikeCount.isSumOfValueGreaterThanMax(ballCount)) {
            throw new IllegalArgumentException(INVALID_TOTAL_COUNT_OF_STRIKE_BALL_EXCEPTION_MESSAGE);
        }
    }

    public static Result of(final int strikeCount, final int ballCount) {
        return new Result(Count.of(strikeCount), Count.of(ballCount));
    }

    public boolean isAllStrike() {
        return strike.isSameValue(NumberBalls.BALL_NUMBER_LENGTH);
    }

    public Count getStrike() {
        return strike;
    }

    public Count getBall() {
        return ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Result result = (Result)o;
        return strike == result.strike &&
            ball == result.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
