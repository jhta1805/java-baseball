public class BaseballServiceImpl implements SportsGameService {

    @Override
    public String playGame(String userNumber) {
        Baseball b = new Baseball();
        b.setComNumber(getRandomInteger(9, 1, 3));
        b.setUserNumber(userNumber);
        System.out.println("상대방 숫자는 " + b.getComNumber() + "입니다.");
        return checkNumber(b.getUserNumber(), b.getComNumber());
    }

    private final Integer NUM_DIGIT = 3;
    private final String OVER_DIGIT_MESSAGE = "세자리 수를 입력해주세요.";
    @Override
    public Boolean checkLength(String userNumber) {
        if (userNumber.length() != NUM_DIGIT) {
            System.out.println(OVER_DIGIT_MESSAGE);
            return false;
        }
        return true;
    }
    private final Integer GAME_QUIT = 000;
    @Override
    public Boolean gameQuit(String userNumber) {
        if (userNumber.equals(GAME_QUIT)) {
            return false;
        }
        return true;
    }

    private final String NOT_INT_MESSAGE = "문자는 안됩니다. 숫자를 입력하세요.";
    @Override
    public Boolean isInt(String userNumber) {
        try {
            Integer.parseInt(userNumber);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(NOT_INT_MESSAGE);
            return false;
        }

    }

    private String checkNumber(String userNumber, String comNumber) {
        int ballCount = 0;
        int strikeCount = 0;
        int cn = Integer.parseInt(comNumber);
        for (int i = 0; i < comNumber.length(); i++) {
            String kcn = cn % 10 + "";
            int chk = reverseStr(userNumber).lastIndexOf(kcn);
            if (chk > -1 && chk != i) {
                ballCount++;
            }
            if (chk == i) {
                strikeCount++;
            }
            cn = cn / 10;
        }
        return result(ballCount, strikeCount);
    }

    private String result(int ballCount, int strikeCount) {
        String res = "";
        if (ballCount > 0) {
            res += ballCount + " ball ";
        }
        if (strikeCount > 0) {
            res += strikeCount + " strike";
        }
        if (ballCount == 0 && strikeCount == 0) {
            res = "nothing";
        }
        return res;
    }

    private String getRandomInteger(int maximum, int minimum, int length) {
        String res = "";
        while(!(res.length() == length)) {
            int num = ((int) (Math.random() * (maximum - minimum))) + minimum;
            if (res.indexOf(num + "") == -1) {
                res +=num;
            }
        }
        return res;
    }


    private static String reverseStr(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }
}

