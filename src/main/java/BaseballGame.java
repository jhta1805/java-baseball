import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    Scanner scanner;
    private String computerNum;
    private String userNum;
    private int strike;
    private int ball;

    public BaseballGame() {
        this.scanner = new Scanner(System.in);
        this.strike = 0;
        this.ball = 0;
    }

    public void start() {
        setRandomNumber();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            userNum = String.valueOf(scanner.nextInt());
            checkNumber();
            break;
        }
    }

    private void checkNumber() {
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
            System.out.print(strike + " 스트라이크 ");
        if (ball > 0)
            System.out.print(ball + "볼");
        System.out.println("");

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

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
            computerNum = String.valueOf(random.nextInt(900) + 100);

            if ((computerNum.charAt(0) != computerNum.charAt(1) && (computerNum.charAt(0) != computerNum.charAt(2)) && (computerNum.charAt(1) != computerNum.charAt(2))))
                break;
        }
    }
}
