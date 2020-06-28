package baseball.view;

import baseball.domain.Count;
import baseball.domain.Result;

public class OutputView {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞혔습니다. 게임종료.";

    private static final String SPLITTER = ", ";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void printCompareResult(final Result compute) {
        final Count strike = compute.getStrikeCount();
        final Count ball = compute.getBallCount();
        if (isNothing(strike, ball)) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        printResultWithAnyMatchingInfo(strike, ball);
    }

    private static boolean isNothing(final Count strike, final Count ball) {
        return strike.getValue() == 0 && ball.getValue() == 0;
    }

    private static void printResultWithAnyMatchingInfo(final Count strike, final Count ball) {
        final StringBuilder result = new StringBuilder();
        appendMessageIfValueExists(result, strike.getValue(), STRIKE_MESSAGE);
        appendCommaIfAllResultExists(result, strike.getValue(), ball.getValue());
        appendMessageIfValueExists(result, ball.getValue(), BALL_MESSAGE);
        result.append(LINE_SEPARATOR);
        System.out.print(result);
    }

    private static void appendCommaIfAllResultExists(final StringBuilder result, final int strike, final int ball) {
        if (strike * ball != 0) {
            result.append(SPLITTER);
        }
    }

    private static void appendMessageIfValueExists(final StringBuilder result, final int value, final String message) {
        if (value != 0) {
            result.append(value);
            result.append(message);
        }
    }

    public static void printWinningMessage() {
        System.out.println(GAME_END_MESSAGE);
    }
}
