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
}
