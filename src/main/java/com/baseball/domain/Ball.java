package com.baseball.domain;

public class Ball {
    int ball;
    public int createComputeBall() {
        this.ball = (int) (Math.random()*100)+111;
        return this.ball;
    }
}
