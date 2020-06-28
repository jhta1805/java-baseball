public class BaseballServiceImpl implements BaseballService {

    @Override
    public String playGame(String userNumber) {
        Baseball b = new Baseball();
        b.setComNumber(getRandomInteger(9, 1, 3));
        b.setUserNumber(userNumber);
        System.out.println("상대방 숫자는 " + b.getComNumber() + "입니다.");
        return checkNumber(b.getUserNumber(), b.getComNumber());
    }

    @Override
    public String checkNumber(String userNumber, String comNumber) {
        int bcnt = 0;
        int scnt = 0;
        int cn = Integer.parseInt(comNumber);
        for (int i = 0; i < comNumber.length(); i++) {
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

    @Override
    public Boolean checkLength(String userNumber) {
        if (userNumber.length() != 3) {
            System.out.println("세자리 수를 입력해주세요.");
            return false;
        }
        return true;
    }

    @Override
    public Boolean gameQuit(String userNumber) {
        if (userNumber.equals("000")) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean isInt(String userNumber) {
        try {
            Integer.parseInt(userNumber);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("문자는 안됩니다. 숫자를 입력하세요.");
            return false;
        }

    }

    @Override
    public String result(int bCnt, int sCnt) {
        String res = "";
        if (bCnt > 0) {
            res += bCnt + " ball ";
        }
        if (sCnt > 0) {
            res += sCnt + " strike";
        }
        if (bCnt == 0 && sCnt == 0) {
            res = "nothing";
        }
        return res;
    }

    public String getRandomInteger(int maximum, int minimum, int length) {
        String res = "";
        for (int i = 0; i < length; i++) {
            res += ((int) (Math.random() * (maximum - minimum))) + minimum;
        }
        return res;
    }


    public static String reverseStr(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }
}
