package service;

import constant.Message;
import domain.Computer;
import domain.User;

import java.util.Random;

public class BaseballService {
    public void setRandomNumber(Computer computer) {
        Random random = new Random();

        while (true) {
            computer.makeRandomNumberToString(random.nextInt(900) + 100);
            if (computer.notExistsDuplicateDigit())
                break;
        }
        System.out.println("computerNum : " + computer.getComputerNum());
    }

    public boolean isCorrectNumber(Computer computer, User user) {
        String computerNum = computer.getComputerNum();
        String userNum = user.getUserNum();

        int strike = getStrikeResult();
        int ball = getBallResult();

//        for (int i=0; i<userNum.length(); i++) {
//            for (int j=0; j<computerNum.length(); j++) {
//                if (i == j) {
//                    if (userNum.charAt(i) == computerNum.charAt(j))
//                        strike++;
//                } else {
//                    if (userNum.charAt(i) == computerNum.charAt(j))
//                        ball++;
//                }
//            }
//        }

        if (strike > 0)
            System.out.print(strike + Message.STRIKE_MESSAGE);
        if (ball > 0)
            System.out.print(ball + Message.BALL_MESSAGE);
        if (strike == 0 && ball == 0)
            System.out.print(Message.NO_STRIKE_NO_BALL_MESSAGE);
        System.out.println("");

        if (strike == 3) {
            return true;
        }

        return false;
    }

    private int getBallResult() {

    }

    private int getStrikeResult() {

    }
}
