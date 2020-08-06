package com.baseball;

import com.baseball.domain.BaseBallPlayService;

import java.io.IOException;

public class BaseBallMainApplication {
    public static void main(String[] args) throws IOException {
        BaseBallPlayService baseBallPlayService = new BaseBallPlayService();
        baseBallPlayService.playGame();
    }
}
