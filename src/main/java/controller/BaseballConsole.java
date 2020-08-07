package controller;
import constant.Message;
import domain.Computer;
import domain.Result;
import domain.User;
import service.BaseballService;

import java.util.Scanner;

public class BaseballConsole {
    private Scanner scanner;
    private Computer computer;
    private User user;
    private Result result;
    private BaseballService baseballService;

    public BaseballConsole() {
        this.scanner = new Scanner(System.in);
        this.computer = new Computer();
        this.user = new User();
        this.result = new Result();
        this.baseballService = new BaseballService();
    }

    public void start() {
        while (true) {
            baseballService.setRandomNumber(computer);

            enterNumber();
            selectMenu();
        }
    }

    public void enterNumber() {
        while (true) {
            try {
                System.out.print(Message.INPUT_NUMBER_MESSAGE);
                user.inputNumberToString(scanner);
                result = baseballService.getGameResult(computer, user);
                printGameResult(result);
                if (result.isThreeStrike()) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void selectMenu() {
        System.out.println(Message.SUCCESS_MESSAGE);

        int selectMenuNum = scanner.nextInt();

        switch (selectMenuNum) {
            case 1 :
                break;
            case 2 :
                System.exit(0);
        }
    }

    private void printGameResult(Result result) {
        int strike = result.getStrike();
        int ball = result.getBall();

        if (strike > 0)
            System.out.print(strike + Message.STRIKE_MESSAGE);
        if (ball > 0)
            System.out.print(ball + Message.BALL_MESSAGE);
        if (strike == 0 && ball == 0)
            System.out.print(Message.NO_STRIKE_NO_BALL_MESSAGE);
        System.out.println("");
    }
}
