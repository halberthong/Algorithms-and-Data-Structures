import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;

public class JunitTest {
    /*
    Add @Ignore before @Test if you don't run the test case
    */
    public static SortingAndSearching ss;
    @BeforeClass
    public static void oneTimeSetUp() {
        ss = new SortingAndSearching();
    }

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
}
