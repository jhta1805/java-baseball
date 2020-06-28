package baseball.view;

import baseball.domain.Result;

public class OutputView {
    public static void printCompareResult(Result compute) {
        int strikeCount = compute.getStrikeCount();
        int ballCount = compute.getBallCount();
        System.out.printf("%d 스트라이크, %d 볼\n", strikeCount, ballCount);
    }

    public static void printWinningMessage() {
        System.out.println("3개의 숫자를 모두 맞혔습니다. 게임종료.");
    }
}
