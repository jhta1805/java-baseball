import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.initNumber();
        System.out.println(c.initNumber());
    }
    static class Computer  {
        private List<Integer> initNumber() {
            List<Integer> number = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                int randomNum = (int) (Math.random()*10);
                number.add(randomNum);
            }
            return number;
        }
        private String checkNumber(Integer userNumber, List<Integer> computerNum) {



            return "";
        }
    }

}
