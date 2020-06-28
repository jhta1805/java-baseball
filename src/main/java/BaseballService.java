public interface BaseballService {
    String playGame(String userInput);
    String checkNumber(String userNumber, String comNumber);
    String result(int bnt, int cnt);
    Boolean gameQuit(String userNumber);
    Boolean isInt(String userNumber);
    Boolean checkLength(String userNumber);
}
