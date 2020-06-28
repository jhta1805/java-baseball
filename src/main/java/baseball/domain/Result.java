package baseball.domain;

import java.util.Objects;

public class Result {
    private final int strikeCount;
    private final int ballCount;

    public Result(int strikeCount, int ballCount) {
        verifyCounts(strikeCount, ballCount);
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    private void verifyCounts(int strikeCount, int ballCount) {
        if (strikeCount < 0 || strikeCount > NumberBalls.BALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (ballCount < 0 || ballCount > NumberBalls.BALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        if (strikeCount + ballCount > NumberBalls.BALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isAllStrike() {
        return strikeCount == NumberBalls.BALL_NUMBER_LENGTH;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
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
