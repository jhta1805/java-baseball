package service;

import domain.Computer;
import domain.Result;
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

    public Result getGameResult(Computer computer, User user) {
        Result gameResult = calculateGameResult(computer, user);
        return gameResult;
    }

    private Result calculateGameResult(Computer computer, User user) {
        String userNum = user.getUserNum();
        String computerNum = computer.getComputerNum();
        Result gameResult = new Result();

        for (int i=0; i<userNum.length(); i++) {
            int userDigit = userNum.charAt(i);
            int computerDigit = computerNum.charAt(i);

            if (isStrike(userDigit, computerDigit)) {
                gameResult.plusStrike();
            } else if (isBall(userDigit, computer)) {
                gameResult.plusBall();
            }
        }

        return gameResult;
    }

    private boolean isStrike(int userDigit, int computerDigit) {
        return userDigit == computerDigit;
    }

    private boolean isBall(int userDigit, Computer computer) {
        String computerNum = computer.getComputerNum();

        for (int i=0; i<computerNum.length(); i++) {
            int computerDigit = computerNum.charAt(i);
            if (userDigit == computerDigit) {
                return true;
            }
        }
        return false;
    }
}
