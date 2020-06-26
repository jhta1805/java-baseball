package com.baseball;

import java.util.Scanner;

class Strike {
    public String zone(int zones, int computer) {
        System.out.println(computer);
        System.out.println(zones);
        if (!verification(zones)) {
            System.out.println("3자리의 숫자만 입력 가능 합니다.");
            return "";
        }
        int ball = 0, str = 0;
        for (int i = 0; i < String.valueOf(zones).length(); i++) {
            if (String.valueOf(zones).charAt(i) == String.valueOf(computer).charAt(i)) {
                str++;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (String.valueOf(zones).charAt(i) == String.valueOf(computer).charAt(j)) ball++;
            }
        }
        return result(str, ball);
    }

    public String result(int str, int ball) {
        String rst = "";
        if (str == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            return "clear";
        } else if (str == 0 && ball == 0) {
            rst = "nothing";
        }
        if (str > 0) rst = str + "스트라이크 ";
        if (ball > 0) rst += ball + "볼 ";

        System.out.println(rst);
        return rst;
    }

    public Boolean verification(int zones) {

        if ((int) Math.log10(zones) + 1 > 3 || (int) Math.log10(zones) + 1 < 3) {
            return false;
        }
        return true;
    }
};

public class Baseball {
    public static int computer = (int) (Math.random() * (100 - 1) + 111);
    public static String msg = "";
    public static Scanner scanner = new Scanner(System.in);
    public static Strike strike = new Strike();
    public static int zone = 0;
    public static int coin = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.printf("숫자를 입력해 주세요 : ");
            zone = scanner.nextInt();
            msg = strike.zone(zone, computer);
            if (msg.equals("clear")) {
                coin = scanner.nextInt();
                if (coin == 2) {
                    scanner.close();
                    break;
                } else {
                    computer = (int) (Math.random() * (100 - 1) + 111);
                }
            }
        }
    }
}
