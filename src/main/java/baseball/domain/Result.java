package baseball.domain;

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
}
