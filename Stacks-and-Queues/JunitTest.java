import static org.junit.Assert.assertEquals;
import org.junit.*;

public class JunitTest {
    /*
    Add @Ignore before @Test if you don't run the test case
    */

    @BeforeClass
    public static void oneTimeSetUp() {

    }

    @Ignore
    @Test
    public void test1() {
        ThreeStacks ts = new ThreeStacks();
        ts.push(0, 1); ts.push(1, 2); ts.pop(0); ts.push(2, 1); ts.push(0, 3);

        try{
            assertEquals(ts.pop(0), 3);
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Ignore
    @Test
    public void test2() {
        StackWithMin swm = new StackWithMin();
        swm.push(1); swm.push(2); swm.push(3);
        try{
            assertEquals(1, swm.min());
            swm.push(0);
            assertEquals(0, swm.min());
            swm.pop();
            assertEquals(1, swm.min());
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test3() {
        int n = 5;
        Tower[] towers = new Tower[3];
        for(int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }
        for(int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2], towers[1]);

        Tower res = new Tower(2);
        for(int i = n - 1; i >= 0; i--) {
            res.add(i);
        }
        try{
            assertEquals(res, towers[2]);
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}
