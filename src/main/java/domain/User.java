package domain;

import constant.Message;

import java.util.Scanner;

public class User {
    private String userNum;

    public void inputNumberToString(Scanner scanner) throws Exception {
        this.userNum = String.valueOf(scanner.nextInt());

        if (notNumberLengthIsThree()) {
            throw new Exception(Message.INCORRECT_DIGIT_MESSAGE);
        } else if (existsDuplicateDigit()) {
            throw new Exception(Message.DUPLICATE_DIGIT_MESSAGE);
        }
    }

    public boolean notNumberLengthIsThree() {
        return this.userNum.length() != 3;
    }

    public boolean existsDuplicateDigit() {
        return (userNum.charAt(0) == userNum.charAt(1)) ||
                (userNum.charAt(0) == userNum.charAt(2)) ||
                (userNum.charAt(1) == userNum.charAt(2));
    }

    public String getUserNum() {
        return userNum;
    }
}
