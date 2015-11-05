import java.util.*;

public class BogglePlayer {
    private String name;
    private Scanner sc;
    public BogglePlayer(String n) {
        this.name = n;
    }
    public List<Point> choosePoints() {
        System.out.println("Please input you choice, stop with \"end\"");
        sc = new Scanner(System.in);
        List<Point> points = new LinkedList<Point>();
        while (sc.hasNext()) {
            String inline = sc.nextLine();
            if (inline.equals("end")) {
                return points;
            } else {
                String[] nums = inline.split(" ");
                if (nums == null || nums.length != 2) return points;
                Point newPoint = new Point(Integer.valueOf(nums[0]), Integer.valueOf(nums[1]));
                points.add(newPoint);
            }
        }
        return points;
    }
}
