import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Computer c = new Computer();
        Boolean scannerChk = true;
        String userInput = "";
        System.out.println("1부터 9까지로 이루어진 숫자 3개를 눌러주세요.\n더 이상 게임을 원하지 않을경우 000 을 입력하세요.");
        while (scannerChk) {
            String computerInput = c.initNumber();
            Scanner sc = new Scanner(System.in);
            System.out.println("숫자를 입력하세요.");
            userInput = sc.next();
            if (userInput.equals("000")) {
                scannerChk = false;
                break;
            }
            if (userInput.length() != 3) {
                System.out.println("숫자를 다시 입력해주세요.");
                continue;
            }
            System.out.println(c.checkNumber(userInput, computerInput));
            System.out.println("상대방 숫자는 " + computerInput + "입니다.");

        }
        System.out.println("게임이 종료됐습니다. 감사합니다.");
    }

    static class Computer {
        private String initNumber() {
            return getRandomInteger(9, 1, 3);
        }

        public static String getRandomInteger(int maximum, int minimum, int length) {
            String res = "";
            for (int i = 0; i < length; i++) {
                res += ((int) (Math.random() * (maximum - minimum))) + minimum;
            }
            return res;
        }

        private String checkNumber(String userNumber, String computerNum) {
            int bcnt = 0;
            int scnt = 0;
            int cn = Integer.parseInt(computerNum);
            for (int i = 0; i < computerNum.length(); i++) {
                String kcn = cn % 10 + "";
                int chk = reverseStr(userNumber).lastIndexOf(kcn);
                if (chk > -1 && chk != i) {
                    bcnt++;
                }
                if (chk == i) {
                    scnt++;
                }
                cn = cn / 10;
            }
            return result(bcnt, scnt);
        }

        private String result(int bcnt, int scnt) {
            String res = "";
            if (bcnt > 0) {
                res += bcnt + " ball ";
            }
            if (scnt > 0) {
                res += scnt + " strike";
            }
            if (bcnt == 0 && scnt == 0) {
                res = "nothing";
            }
            return res;
        }
    }

    public static String reverseStr(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }
}
