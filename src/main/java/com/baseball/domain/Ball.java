package com.baseball.domain;

public class Ball {
    String computerBall;
    String userBall;
    String findBallBuffer;
    int strikeCount = 0;
    int ballCount = 0;

    StringBuffer pitchZone = new StringBuffer();
    StringBuilder stringBuilder = new StringBuilder();

    public String createComputeBall() {
        do {
            int createNumber = (int) (Math.random() * 9) + 1;
            if (createNumber > 0) {
                stringBuilder.append(createNumber);
                this.computerBallInspection(createNumber);
            }
        } while (stringBuilder.length() != 3);
        computerBall = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        findBallBuffer = computerBall;
        return computerBall;
    }

    public void computerBallInspection(int number) {
        if (stringBuilder.length() >= 2) {
            int index = stringBuilder.substring(0, stringBuilder.length()-1).indexOf(String.valueOf(number));
            if (index > -1) {
                stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
                createComputeBall();
            }
        }
    }

}
