package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ManualNumberBallsFactory implements NumberBallsGenerator {
    private static final int EXTRACT_COMPLETE_CRITERIA = 0;
    private static final int EXTRACT_BALL_NUMBER_DIVIDER = 10;

    private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수는 허용되지 않습니다.";

    private final int number;

    public ManualNumberBallsFactory(final int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(final int number) {
        if (number < EXTRACT_COMPLETE_CRITERIA) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public NumberBalls generateBalls() {
        final List<NumberBall> result = new ArrayList<>();
        final Stack<NumberBall> numberBalls = extractNumberBalls();
        while (!numberBalls.empty()) {
            result.add(numberBalls.pop());
        }
        return new NumberBalls(result);
    }

    private Stack<NumberBall> extractNumberBalls() {
        final Stack<NumberBall> numberBallStack = new Stack<>();
        int num = number;
        while (num > EXTRACT_COMPLETE_CRITERIA) {
            numberBallStack.push(NumberBall.of(num % EXTRACT_BALL_NUMBER_DIVIDER));
            num /= EXTRACT_BALL_NUMBER_DIVIDER;
        }
        return numberBallStack;
    }
}
