public interface SportsGameService {
//    baseball game 뿐만 아니라 나중에 soccer 등의 확장성으 고려해 service 로 만듦
    String playGame(String userInput);
    Boolean gameQuit(String userNumber);
    Boolean isInt(String userNumber);
    Boolean checkLength(String userNumber);
}
