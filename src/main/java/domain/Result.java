package domain;

public class Result {
    private int strike;
    private int ball;

    public Result() {
        this.strike = 0;
        this.ball = 0;
    }

    public void plusStrike() {
        this.strike++;
    }

    public void plusBall() {
        this.ball++;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public boolean isThreeStrike() {
        return this.strike == 3;
    }
}
