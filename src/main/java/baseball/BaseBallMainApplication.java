package baseball;

import baseball.domain.AutoNumberBallsGenerator;
import baseball.domain.ManualNumberBallsGenerator;
import baseball.domain.NumberBalls;
import baseball.domain.NumberBallsGenerator;
import baseball.domain.WhetherReplay;
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
        } while (inputWhetherReplay().isReplay());
    }

    private static void inputNumberWhileAllStrike(final NumberBalls computerBalls) {
        while (true) {
            final NumberBalls playerBalls = inputPlayerBalls();
            final Result computeResult = computerBalls.compute(playerBalls);
            OutputView.printCompareResult(computeResult);
            if (computeResult.isAllStrikes()) {
                break;
            }
        }
    }

    private static NumberBalls inputPlayerBalls() {
        while (true) {
            try {
                final NumberBallsGenerator manualBallsGenerator = new ManualNumberBallsGenerator(
                    InputView.inputBaseBallNumbers());
                return manualBallsGenerator.generateBalls();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private static WhetherReplay inputWhetherReplay() {
        while (true) {
            try {
                return WhetherReplay.of(InputView.inputWhetherReplay());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
