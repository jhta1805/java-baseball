package baseball.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Integer inputBaseBallNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return parseInt(SCANNER.next());
    }

    private static Integer parseInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 외의 값은 입력 받을 수 없습니다.");
        }
    }

    public static String inputPlayAgain() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.: ");
        return SCANNER.next();
    }
}
