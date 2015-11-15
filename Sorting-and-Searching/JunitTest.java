import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;

class Point {
    int x;
    int y;
    Point(int xx, int yy) {
        x = xx;
        y = yy;
    }
}

public class JunitTest {
    /*
    Add @Ignore before @Test if you don't run the test case
    */
    public static SortingAndSearching ss;
    @BeforeClass
    public static void oneTimeSetUp() {
        ss = new SortingAndSearching();
    }

    @Ignore
    @Test
    public void test1() {
        int[] A = {1, 3, 5, 0, 0};
        int[] B = {2, 4};
        ss.mergeSortedArray(A, 3, B, 2);
        int[] res = {1, 2, 3, 4, 5};
        try{
            assertArrayEquals(res, A);
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Ignore
    @Test
    public void test2() {
        String s = "bassaabb";
        CharacterFreqRank cfr = new CharacterFreqRank(s);
        cfr.print();
    }

    @Test
    public void test3() {
        Point[] points = new Point[]{
            new Point(1, 1),
            new Point(1, 2),
            new Point(0, 1),
            new Point(1, 0)
        };
        Point[] topK = ss.findKPoints(points, 2);
        for (Point p : topK) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
