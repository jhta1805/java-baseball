package com.baseball.domain;

import com.baseball.view.InputView;
import com.baseball.view.OutputView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseBallPlayService implements BaseballPlayImpl {
    private static final OutputView outputView = new OutputView();
    private static final Ball ball = new Ball();
    private static String computerBall = ball.createComputeBall();

    @Override
    public void playGame() {
        outputView.messagePrint("START", "");
        ball.userBall = InputView.inputBalls();
        this.userBallNumberVerification(ball.userBall);
        this.baseBallMatching(ball.userBall);
        outputView.messagePrint("GAME_RESULT", ball.pitchZone.toString());
        this.messageDelete();
        this.gameRestartOrGameEnd();
    }

    public void userBallNumberVerification(String userBall) {
        try {
            Pattern pattern = Pattern.compile("(^[0-9]{3})");
            Matcher matchingResult = pattern.matcher(String.valueOf(userBall));
            if (!matchingResult.find()) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            outputView.messagePrint("VERIFICATION", "");
            InputView.getClose();
            e.printStackTrace();
            throw e;
        }
    }

    public void baseBallMatching(String userBall) {
        if (!userBall.trim().isEmpty()) {
            if (String.valueOf(userBall.charAt(0)).equals(String.valueOf(computerBall.charAt(0)))) {
                ball.strikeCount++;
            }
            if (ball.findBallBuffer.indexOf(String.valueOf(userBall.charAt(0))) > 0) {
                ball.ballCount++;
            }
            userBall = userBall.substring(1);
            computerBall = computerBall.substring(1);
            baseBallMatching(userBall);
        } else {
            if (ball.strikeCount > 0) ball.pitchZone.append(ball.strikeCount).append(" 스트라이크 ");
            if (ball.ballCount > 0) ball.pitchZone.append(ball.ballCount).append(" 볼");
        }
    }

    public void gameRestartOrGameEnd() {
        int coin = 0;
        if (ball.strikeCount < 3) {
            computerBall = String.valueOf(ball.computerBall);
            playGame();
        } else {
            outputView.messagePrint("GAME_COMPLETE", ball.pitchZone.toString());
            coin = InputView.inputCoin();
        }
        this.messageDelete();
        if(coin == 1) this.gameReset();
        else InputView.getClose();
    }

    public void gameReset() {
        computerBall = ball.createComputeBall();
        ball.strikeCount = 0;
        ball.ballCount = 0;
        this.playGame();
    }

    public void messageDelete() {
        ball.strikeCount = 0;
        ball.ballCount = 0;
        ball.pitchZone.delete(0, ball.pitchZone.length());
    }

}
