import java.util.*;

public class BoggleGame {
    public static void main(String[] args) throws Exception {
        BoggleBoard bb = new BoggleBoard(10);
        bb.printBoard();
        BogglePlayer player = new BogglePlayer("Mike");
        List<Point> points = player.choosePoints();
        if (bb.isCorrect(points)) {
            System.out.println("correct answer");
        } else {
            System.out.println("wrong answer");
        }
    }
}
