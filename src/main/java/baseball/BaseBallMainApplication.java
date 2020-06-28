package baseball;

import baseball.domain.AutoNumberBallsFactory;
import baseball.domain.ManualNumberBallsFactory;
import baseball.domain.NumberBalls;
import baseball.domain.NumberBallsFactory;
import baseball.domain.PlayerChoice;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallMainApplication {
    public static void main(String[] args) {
        NumberBallsFactory numberBallsFactory = new AutoNumberBallsFactory();
        do {
            NumberBalls computerBalls = numberBallsFactory.generateBalls();
            inputPlayerBallsWhileAllStrike(computerBalls);
            OutputView.printWinningMessage();
        } while (inputPlayGameAgain().isPlayAgain());
    }

    private static void inputPlayerBallsWhileAllStrike(NumberBalls computerBalls) {
        while (true) {
            NumberBalls playerBalls = inputPlayerNumberBalls();
            Result compute = computerBalls.compute(playerBalls);
            OutputView.printCompareResult(compute);
            if (compute.isAllStrike()) {
                break;
            }
        }
    }

    private static NumberBalls inputPlayerNumberBalls() {
        while (true) {
            try {
                NumberBallsFactory manualNumberBallsFactory = new ManualNumberBallsFactory(
                    InputView.inputBaseBallNumbers());
                return manualNumberBallsFactory.generateBalls();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static PlayerChoice inputPlayGameAgain() {
        while (true) {
            try {
                return PlayerChoice.of(InputView.inputPlayAgain());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
