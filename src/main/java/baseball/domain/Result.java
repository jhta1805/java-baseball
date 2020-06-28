package baseball.domain;

import java.util.Objects;

public final class Result {
    private static final String INVALID_TOTAL_COUNT_OF_STRIKE_BALL_EXCEPTION_MESSAGE =
        "스트라이크와 볼의 값의 합이 현재 가능한 값을 넘었습니다.";

    private final Count strikeCount;
    private final Count ballCount;

    private Result(Count strikeCount, Count ballCount) {
        verifyCounts(strikeCount, ballCount);
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    private void verifyCounts(Count strikeCount, Count ballCount) {
        if (strikeCount.isSumOfValueGreaterThanMax(ballCount)) {
            throw new IllegalArgumentException(INVALID_TOTAL_COUNT_OF_STRIKE_BALL_EXCEPTION_MESSAGE);
        }
    }

    public static Result of(int strikeCount, int ballCount) {
        return new Result(Count.of(strikeCount), Count.of(ballCount));
    }

    public boolean isAllStrike() {
        return strikeCount.isSameValue(NumberBalls.BALL_NUMBER_LENGTH);
    }

    public Count getStrikeCount() {
        return strikeCount;
    }

    public Count getBallCount() {
        return ballCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Result result = (Result)o;
        return strikeCount == result.strikeCount &&
            ballCount == result.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
