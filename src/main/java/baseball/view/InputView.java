package baseball.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NON_NUMBER_INPUT_EXCEPTION_MESSAGE = "숫자 외의 값은 입력 받을 수 없습니다.";
    private static final String INPUT_PLAY_AGAIN_INTRO_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.: ";
    private static final String INPUT_BASEBALL_NUMBER_INTRO_MESSAGE = "숫자를 입력해주세요 : ";

    public static Integer inputBaseBallNumbers() {
        System.out.print(INPUT_BASEBALL_NUMBER_INTRO_MESSAGE);
        return parseInt(SCANNER.next());
    }

    private static Integer parseInt(final String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMBER_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static String inputWhetherReplay() {
        System.out.print(INPUT_PLAY_AGAIN_INTRO_MESSAGE);
        return SCANNER.next();
    }
}
