package com.baseball;

import com.baseball.domain.BaseBallPlayService;

public class BaseBallMainApplication {
    public static void main(String[] args) {
        BaseBallPlayService baseBallPlayService = new BaseBallPlayService();
        baseBallPlayService.playGame();
    }
}
