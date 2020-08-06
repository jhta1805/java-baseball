package com.baseball.mssage;

public enum Message {
    START_MESSAGE("숫자를 입력해주세요 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
