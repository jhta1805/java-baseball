package com.baseball.mssage;

public enum Message {
    START_MESSAGE("숫자를 입력해주세요 : "),
    VERIFICATION_MESSAGE("볼 입력이 잘못되었습니다.");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
