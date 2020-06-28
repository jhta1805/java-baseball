package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class NumberBalls {
    static final int BALL_NUMBER_LENGTH = 3;

    private static final String INVALID_BALLS_ARGUMENT_EXCEPTION_MESSAGE = "입력 값이 유효하지 않습니다.";
    private static final String DUPLICATE_NUMBER_CONTAINS_EXCEPTION_MESSAGE = "중복된 값은 들어갈 수 없습니다.";
    private static final String NULL_ARGUMENT_EXCEPTION_MESSAGE = "Null객체는 허용되지 않습니다.";

    private final List<NumberBall> balls;

    public NumberBalls(final List<NumberBall> balls) {
        verifyArgument(balls);
        this.balls = Collections.unmodifiableList(new ArrayList<>(balls));
    }

    private void verifyArgument(List<NumberBall> balls) {
        verifyNonNull(balls);
        verifyNoContainsDuplicateBall(balls);
        verifyLength(balls);
    }

    private void verifyNonNull(List<NumberBall> balls) {
        if (Objects.isNull(balls)) {
            throw new IllegalArgumentException(NULL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    private void verifyNoContainsDuplicateBall(List<NumberBall> balls) {
        Set<NumberBall> numberBalls = new HashSet<>(balls);
        if (balls.size() != numberBalls.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_CONTAINS_EXCEPTION_MESSAGE);
        }
    }

    private void verifyLength(List<NumberBall> balls) {
        if (balls.size() != BALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_BALLS_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    public Result compute(NumberBalls otherBalls) {
        int strikeCount = computeStrike(otherBalls);
        int ballCount = computeBall(otherBalls, strikeCount);
        return Result.of(strikeCount, ballCount);
    }

    private int computeStrike(NumberBalls comparer) {
        int strikeCount = 0;
        for (int i = 0; i < this.balls.size(); i++) {
            if (this.balls.get(i).equals(comparer.balls.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int computeBall(NumberBalls otherBalls, int strikeCount) {
        int ballCandidateCount = getBallCandidateCount(otherBalls);
        return ballCandidateCount - strikeCount;
    }

    private int getBallCandidateCount(NumberBalls comparer) {
        List<NumberBall> otherBalls = comparer.balls;
        Set<NumberBall> distinctNumbers = new HashSet<>(this.balls);
        distinctNumbers.addAll(otherBalls);
        return this.balls.size() + otherBalls.size() - distinctNumbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NumberBalls that = (NumberBalls)o;
        return Objects.equals(balls, that.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
