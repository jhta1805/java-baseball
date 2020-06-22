package com.baseball;

import java.util.Scanner;

class Strike {
    public String zone(int zones, int computer) {

        String rst = "";
        if((int) Math.log10(zones)+1 > 3 || (int) Math.log10(zones)+1 < 3) {
            System.out.println("3자리의 숫자만 입력 가능 합니다.");
            return "";
        }
        System.out.println(computer);
        System.out.println(zones);
        int ball = 0, str = 0;
        for (int i = 0; i < String.valueOf(zones).length(); i++) {
            if (String.valueOf(zones).charAt(i) == String.valueOf(computer).charAt(i)) {
                str++;
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (String.valueOf(zones).charAt(i) == String.valueOf(computer).charAt(j)) {
                    ball++;
                }
            }
        }
        if (str == 3) {
            return "clear";
        } else if (str == 0 && ball == 0) {
            return "nothing";
        }
        rst = str > 0 ? str + "스트라이크 " : "";
        rst += ball > 0 ? ball + "볼 " : "";
        return rst;
    }

    ;
};

public class Baseball {
    public static void main(String[] args) {
        int computer = (int) (Math.random() * (100 - 1) + 111);
        int zone = 0;
        Scanner scanner = new Scanner(System.in);

        Strike strike = new Strike();
        String result = "";
        int restart = 0;

        while (true) {
            System.out.printf("숫자를 입력해 주세요 : ");
            zone = scanner.nextInt();
            result = strike.zone(zone, computer);

            if (result.equals("clear")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restart = scanner.nextInt();
                if (restart == 2) {
                    scanner.close();
                    break;
                } else {
                    computer = (int) (Math.random() * (100 - 1) + 111);
                }
            } else {
                System.out.println(result);
            }
        }
    }
}
