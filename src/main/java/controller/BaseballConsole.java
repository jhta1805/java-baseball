package controller;
import constant.Message;
import domain.Computer;
import domain.User;
import service.BaseballService;

import java.util.Scanner;

public class BaseballConsole {
    private Scanner scanner;
    private Computer computer;
    private User user;
    private BaseballService baseballService;

    public BaseballConsole() {
        this.scanner = new Scanner(System.in);
        this.computer = new Computer();
        this.user = new User();
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
                user.inputNumberToString(scanner.nextInt());

                if (user.notNumberLengthIsThree()) {
                    throw new Exception(Message.INCORRECT_DIGIT_MESSAGE);
                }

                if (baseballService.isCorrectNumber(computer, user))
                    break;
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
}
