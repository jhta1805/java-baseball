package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ManualNumberBallsFactory implements NumberBallsFactory {
    private static final int EXTRACT_COMPLETE_CRITERIA = 0;
    private static final int EXTRACT_BALL_NUMBER_DIVIDER = 10;

    private final int number;

    public ManualNumberBallsFactory(int number) {
        this.number = number;
    }

    @Override
    public NumberBalls generateBalls() {
        List<NumberBall> result = new ArrayList<>();
        Stack<NumberBall> numberBalls = extractNumberBalls();
        while (!numberBalls.empty()) {
            result.add(numberBalls.pop());
        }
        return new NumberBalls(result);
    }

    private Stack<NumberBall> extractNumberBalls() {
        Stack<NumberBall> numberBallStack = new Stack<>();
        int num = number;
        while (num > EXTRACT_COMPLETE_CRITERIA) {
            numberBallStack.push(NumberBall.of(num % EXTRACT_BALL_NUMBER_DIVIDER));
            num /= EXTRACT_BALL_NUMBER_DIVIDER;
        }
        return numberBallStack;
    }
}
