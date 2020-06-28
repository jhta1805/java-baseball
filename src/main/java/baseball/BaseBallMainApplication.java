package baseball;

import baseball.domain.AutoNumberBallsGenerator;
import baseball.domain.ManualNumberBallsFactory;
import baseball.domain.NumberBalls;
import baseball.domain.NumberBallsGenerator;
import baseball.domain.PlayerChoice;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallMainApplication {
    public static void main(String[] args) {
        final NumberBallsGenerator numberBallsGenerator = new AutoNumberBallsGenerator();
        do {
            final NumberBalls computerBalls = numberBallsGenerator.generateBalls();
            inputNumberWhileAllStrike(computerBalls);
            OutputView.printWinningMessage();
        } while (inputPlayGameAgain().isPlayAgain());
    }

    private static void inputNumberWhileAllStrike(final NumberBalls computerBalls) {
        while (true) {
            final NumberBalls playerBalls = inputPlayerNumberBalls();
            final Result compute = computerBalls.compute(playerBalls);
            OutputView.printCompareResult(compute);
            if (compute.isAllStrike()) {
                break;
            }
        }
    }

    private static NumberBalls inputPlayerNumberBalls() {
        while (true) {
            try {
                final NumberBallsGenerator manualNumberBallsGenerator = new ManualNumberBallsFactory(
                    InputView.inputBaseBallNumbers());
                return manualNumberBallsGenerator.generateBalls();
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
