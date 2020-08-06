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
        this.outputView.startInputNumberMessage();
        this.inputView.inputBalls();
    }
}
