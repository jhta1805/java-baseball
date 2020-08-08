package com.baseball.view;

import com.baseball.mssage.Message;

public class OutputView {

    public void messagePrint(String message) {
        switch (message) {
            case "START":
                System.out.println(Message.START_MESSAGE.getMessage());
                break;
            case "VERIFICATION":
                System.out.println(Message.VERIFICATION_MESSAGE.getMessage());
                break;
        }

    }
}
