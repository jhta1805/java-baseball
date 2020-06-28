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
        final NumberBallsGenerator autoGenerator = new AutoNumberBallsGenerator();
        do {
            final NumberBalls computerBalls = autoGenerator.generateBalls();
            inputNumberWhileAllStrike(computerBalls);
            OutputView.printWinningMessage();
        } while (inputPlayGameAgain().isPlayAgain());
    }

    private static void inputNumberWhileAllStrike(final NumberBalls computerBalls) {
        while (true) {
            final NumberBalls playerBalls = inputPlayerNumberBalls();
            final Result computeResult = computerBalls.compute(playerBalls);
            OutputView.printCompareResult(computeResult);
            if (computeResult.isAllStrike()) {
                break;
            }
        }
    }

    private static NumberBalls inputPlayerNumberBalls() {
        while (true) {
            try {
                final NumberBallsGenerator manualBallsGenerator = new ManualNumberBallsFactory(
                    InputView.inputBaseBallNumbers());
                return manualBallsGenerator.generateBalls();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private static PlayerChoice inputPlayGameAgain() {
        while (true) {
            try {
                return PlayerChoice.of(InputView.inputPlayAgain());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
