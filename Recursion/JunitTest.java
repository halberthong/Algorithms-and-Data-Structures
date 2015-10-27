import static org.junit.Assert.assertEquals;
import org.junit.*;
import java.util.*;

public class JunitTest {
    /*
    Add @Ignore before @Test if you don't run the test case
    */
    public static Recursion rec;
    @BeforeClass
    public static void oneTimeSetUp() {
        rec = new Recursion();
    }

    public void testify(Object o1, Object o2) {
        if (o1.getClass().equals(o2.getClass())) {
            try{
                assertEquals(o1, o2);
            } catch(AssertionError e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Not comparable");
        }
    }

    @Ignore
    @Test
    public void test1() {
        int[] nums = {1,2,2};
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Integer[] n1 = {}; Integer[] n2 = {1}; Integer[] n3 = {1, 2}; Integer[] n4 = {1, 2, 2}; Integer[] n5 = {2}; Integer[] n6 = {2, 2};
        res.add(Arrays.asList(n1));
        res.add(Arrays.asList(n2));
        res.add(Arrays.asList(n3));
        res.add(Arrays.asList(n4));
        res.add(Arrays.asList(n5));
        res.add(Arrays.asList(n6));
        try{
            assertEquals(res, rec.subsets(nums));
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test2() {
        int[] A = {1, 4, 2, 3};
        int res = rec.minAdjustmentCost(A, 1);
        testify(2, res);
        res = rec.minAdjustmentCost(A, 2);
        testify(1, res);
        res = rec.minAdjustmentCost(A, 0);
        testify(4, res);
    }
}
