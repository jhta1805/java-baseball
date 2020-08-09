package com.baseball.mssage;

public enum Message {
    START_MESSAGE("숫자를 입력해주세요 : "),
    VERIFICATION_MESSAGE("볼 입력이 잘못되었습니다."),
    GAME_RESULT_MESSAGE("낫 싱"),
    GAME_COMPLETE_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
