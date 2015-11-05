import java.util.*;

public class BoggleBoard {
    private char[][] board;
    private int size;
    private Dictionary dict;
    public BoggleBoard() throws Exception {
        this.size = 4;
        generateBoard();
        dict = Dictionary.getInstance();
    }
    public BoggleBoard(int assignedSize) throws Exception {
        this.size = assignedSize;
        generateBoard();
        dict = Dictionary.getInstance();
    }
    public void generateBoard() {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.board[i][j] = (char)('A' + (int)(Math.random() * 26));
            }
        }
    }
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean isCorrect(List<Point> input) {
        if (input == null || input.size() == 0) {
            return false;
        }
        if (isValidConnection(input)) {
            if (isValidWord(input)) {
                return true;
            }
        }
        return false;
    }
    private boolean isValidConnection(List<Point> input) {
        Point pre = input.get(0);
        for (int i = 1; i < input.size(); i++) {
            int diffx = Math.abs(pre.x - input.get(i).x);
            int diffy = Math.abs(pre.y - input.get(i).y);
            if (diffx > 1 || diffy > 1 || (diffx == 0 && diffy == 0)) {
                return false;
            }
            pre = input.get(i);
        }
        return true;
    }
    private boolean isValidWord(List<Point> input) {
        StringBuilder sb = new StringBuilder();
        for (Point point : input) {
            sb.append(board[point.x][point.y]);
        }
        String inputString = sb.toString().toLowerCase();
        System.out.println(inputString);
        return dict.isWord(inputString);
    }
}
