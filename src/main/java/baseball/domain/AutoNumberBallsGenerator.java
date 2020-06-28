package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoNumberBallsGenerator implements NumberBallsGenerator {
    private static final int BALLS_FIRST_INDEX = 0;

    private final List<NumberBall> allDistinctNumbers = new ArrayList<>();

    public AutoNumberBallsGenerator() {
        init();
    }

    private void init() {
        for (int i = NumberBall.MIN_VALUE; i < NumberBall.MAX_VALUE; i++) {
            allDistinctNumbers.add(NumberBall.of(i));
        }
    }

    @Override
    public NumberBalls generateBalls() {
        Collections.shuffle(allDistinctNumbers);
        return new NumberBalls(allDistinctNumbers.subList(BALLS_FIRST_INDEX, NumberBalls.BALL_NUMBER_LENGTH));
    }
}
