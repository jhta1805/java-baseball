import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BaseballService bs = new BaseballServiceImpl();
        System.out.println("1부터 9까지로 이루어진 숫자 3개를 눌러주세요.\n더 이상 게임을 원하지 않을경우 000 을 입력하세요.");
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("숫자를 입력하세요.");
            String userNumber = sc.next();
            if (!bs.gameQuit(userNumber)) {
                break;
            }
            if (!bs.isInt(userNumber) || !bs.checkLength(userNumber)) {
                continue;
            }
            System.out.println(bs.playGame(userNumber));
        }
        System.out.println("게임이 종료됐습니다. 감사합니다.");
    }
}
