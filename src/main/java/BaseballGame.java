import domain.Computer;
import domain.Result;
import domain.User;
import view.BaseballGameView;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    Scanner scanner;
    private Computer computer;
    private User user;
    private Result result;

    public BaseballGame() {
        this.scanner = new Scanner(System.in);
        this.computer = new Computer();
        this.user = new User();
        this.result = new Result();
    }

    public void start() {
        initResultStats();
        setRandomNumber();
        enterNumber();
        selectMenu();
    }

    private void initResultStats() {
        result.initStrikeAndBallScore();
    }

    private void enterNumber() {
        while (true) {
            try {
                System.out.print(BaseballGameView.INPUT_NUMBER_MESSAGE);
                user.inputNumberToString(scanner.nextInt());

                if (user.notNumberLengthIsThree()) {
                    throw new Exception(BaseballGameView.INCORRECT_DIGIT_MESSAGE);
                }

                if (user.isCorrectNumber(computer))
                    break;
                initResultStats();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void selectMenu() {
        System.out.println(BaseballGameView.SUCCESS_MESSAGE);

        int selectMenuNum = scanner.nextInt();

        switch (selectMenuNum) {
            case 1 :
                start();
            case 2 :
                System.exit(0);
        }
    }

    private void setRandomNumber() {
        Random random = new Random();

        while (true) {
            computer.makeRandomNumberToString(random.nextInt(900) + 100);
            if (computer.notExistsDuplicateDigit())
                break;
        }
        System.out.println("computerNum : " + computer.getComputerNum());
    }
}
