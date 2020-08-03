package com.baseball.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Integer inputBalls() throws IOException {
        System.out.print("숫자를 입력해주세요 : ");
        return Integer.parseInt(br.readLine());
    };

}
