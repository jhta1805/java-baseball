package domain;

public class Computer {
    private String computerNum;

    public void makeRandomNumberToString(int randomNumber) {
        this.computerNum = String.valueOf(randomNumber);
    }

    public boolean notExistsDuplicateDigit() {
        return (computerNum.charAt(0) != computerNum.charAt(1)) &&
                (computerNum.charAt(0) != computerNum.charAt(2)) &&
                (computerNum.charAt(1) != computerNum.charAt(2));
    }

    public String getComputerNum() {
        return computerNum;
    }
}
