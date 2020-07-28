import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    private int number1;
    private int number2;
    private int number3;

    public void start() {
        setRandomNumber();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            int number = scanner.nextInt();
            checkNumber(number);
        }
    }

    private void checkNumber(int number) {

    }

    private void setRandomNumber() {
        Random random = new Random();

        while (true) {
            number1 = random.nextInt(9) + 1;
            number2 = random.nextInt(9) + 1;
            number3 = random.nextInt(9) + 1;

            if ((number1 != number2) && (number1 != number3) && (number2 != number3))
                break;
        }
    }
}
