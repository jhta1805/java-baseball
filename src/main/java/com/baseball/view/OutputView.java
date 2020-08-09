package com.baseball.view;

import com.baseball.mssage.Message;

public class OutputView {

    public void messagePrint(String message, String resultMessage) {
        switch (message) {
            case "START":
                System.out.println(Message.START_MESSAGE.getMessage());
                break;
            case "VERIFICATION":
                System.out.println(Message.VERIFICATION_MESSAGE.getMessage());
                break;
            case "GAME_RESULT":
                if (!resultMessage.isEmpty()) System.out.println(resultMessage);
                else System.out.println(Message.GAME_RESULT_MESSAGE.getMessage());
                break;
            case "GAME_COMPLETE":
                System.out.println(Message.GAME_COMPLETE_MESSAGE.getMessage());
                break;
        }
    }
}
