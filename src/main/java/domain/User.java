package domain;

import view.BaseballGameView;

public class User {
    private String userNum;

    public void inputNumberToString(int number) {
        this.userNum = String.valueOf(number);
    }

    public boolean notNumberLengthIsThree() {
        return this.userNum.length() != 3;
    }

    public boolean isCorrectNumber(Computer computer) {
        String computerNum = computer.getComputerNum();
        for (int i=0; i<userNum.length(); i++) {
            for (int j=0; j<computerNum.length(); j++) {
                if (i == j) {
                    if (userNum.charAt(i) == computerNum.charAt(j))
                        strike++;
                } else {
                    if (userNum.charAt(i) == computerNum.charAt(j))
                        ball++;
                }
            }
        }
        if (strike > 0)
            System.out.print(strike + BaseballGameView.STRIKE_MESSAGE);
        if (ball > 0)
            System.out.print(ball + BaseballGameView.BALL_MESSAGE);
        if (strike == 0 && ball == 0)
            System.out.print(BaseballGameView.NO_STRIKE_NO_BALL_MESSAGE);
        System.out.println("");

        if (strike == 3) {
            return true;
        }

        return false;
    }
}
