package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class NumberBalls {
    static final int BALL_NUMBER_LENGTH = 3;
    private static final int DEFAULT_STRIKE_COUNT_NUMBER = 0;

    private static final String INVALID_BALLS_ARGUMENT_EXCEPTION_MESSAGE = "입력 값이 유효하지 않습니다.";
    private static final String DUPLICATE_NUMBER_CONTAINS_EXCEPTION_MESSAGE = "중복된 값은 들어갈 수 없습니다.";
    private static final String NULL_ARGUMENT_EXCEPTION_MESSAGE = "Null객체는 허용되지 않습니다.";

    private final List<NumberBall> balls;

    public NumberBalls(final List<NumberBall> balls) {
        verifyBalls(balls);
        this.balls = Collections.unmodifiableList(new ArrayList<>(balls));
    }

    private void verifyBalls(final List<NumberBall> balls) {
        verifyNonNull(balls);
        verifyNoContainsDuplicateBall(balls);
        verifyLength(balls);
    }

    private void verifyNonNull(final List<NumberBall> balls) {
        if (Objects.isNull(balls)) {
            throw new IllegalArgumentException(NULL_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    private void verifyNoContainsDuplicateBall(final List<NumberBall> balls) {
        final Set<NumberBall> numberBalls = new HashSet<>(balls);
        if (balls.size() != numberBalls.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_CONTAINS_EXCEPTION_MESSAGE);
        }
    }

    private void verifyLength(final List<NumberBall> balls) {
        if (balls.size() != BALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_BALLS_ARGUMENT_EXCEPTION_MESSAGE);
        }
    }

    public Result compute(final NumberBalls other) {
        final int strike = computeStrike(other);
        final int ball = computeBall(other, strike);
        return Result.of(strike, ball);
    }

    private int computeStrike(final NumberBalls other) {
        int strike = DEFAULT_STRIKE_COUNT_NUMBER;
        for (int i = 0; i < this.balls.size(); i++) {
            if (this.balls.get(i).equals(other.balls.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int computeBall(final NumberBalls other, final int strike) {
        final int ballCandidateCount = computeCountOfBallCandidate(other);
        return ballCandidateCount - strike;
    }

    private int computeCountOfBallCandidate(final NumberBalls other) {
        final List<NumberBall> otherBalls = other.balls;
        final Set<NumberBall> distinctNumbers = new HashSet<>(this.balls);
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
