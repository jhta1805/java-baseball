package com.baseball.domain;

import com.baseball.view.InputView;
import com.baseball.view.OutputView;

import java.io.IOException;

public class BaseBallPlayService implements BaseballPlayImpl{
    private static InputView inputView;
    private static OutputView outputView = new OutputView();
    private static int computerBall = new Ball().createComputeBall();

    @Override
    public void playGame() throws IOException {
        System.out.println(computerBall);
        this.outputView.messagePrint("START");
        int userBall = this.inputView.inputBalls();

        this.userBallNumberVerification(userBall);
    }

    public void userBallNumberVerification(int userBall) {
        try {
            if ((int) (Math.log10(userBall) + 1) > 3) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            this.outputView.messagePrint("VERIFICATION");
            e.printStackTrace();
        }
    }

}
