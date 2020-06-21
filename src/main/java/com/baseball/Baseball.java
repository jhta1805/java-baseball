package com.baseball;

import java.util.Scanner;

class Strike {
    public String zone(int zones, int computer) {

        String rst = "";
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
        if(str == 3){
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        } else if (str == 0 && ball == 0) {
            return "nothing";
        }
        rst = str > 0? str + "스트라이크 " : "";
        rst += ball > 0? ball + "볼 " : "";
        return rst;
    }

    ;
};

public class Baseball {
    public static void main(String[] args) {
        int computer = (int) (Math.random() * (100 - 1) + 111);
        Scanner scanner = new Scanner(System.in);
        System.out.printf("숫자를 입력해 주세요 : ");
        int zone = 0;
        if(!scanner.hasNextInt()) {
            scanner.next();
            System.err.print("1 ~ 9까지의 숫자를 3개 입력해 주세요. \n재 입력 :");
        }
        zone = scanner.nextInt();
        Strike strike = new Strike();
        String result = strike.zone(zone, computer);
        while (!result.equals("3개의 숫자를 모두 맞히셨습니다! 게임 종료")) {
            System.out.println(result);
            zone = scanner.nextInt();
            result = strike.zone(zone, computer);
        }
        scanner.close();
        System.out.println(result);
    }
}
