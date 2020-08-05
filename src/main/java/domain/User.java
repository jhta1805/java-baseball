package domain;

public class User {
    private String userNum;

    public void inputNumberToString(int number) {
        this.userNum = String.valueOf(number);
    }

    public boolean notNumberLengthIsThree() {
        return this.userNum.length() != 3;
    }

    public String getUserNum() {
        return userNum;
    }
}
