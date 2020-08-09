package com.baseball.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;
    public static String inputBalls() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int inputCoin() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void getClose() {
        scanner.close();
    }


}
