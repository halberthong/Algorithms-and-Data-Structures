import static org.junit.Assert.assertEquals;
import org.junit.*;

public class JunitTest {
    /*
    Add @Ignore before @Test if you don't run the test case
    */

    static ThreeStacks ts;

    @BeforeClass
    public static void oneTimeSetUp() {
        ts = new ThreeStacks();
    }

    @Test
    public void test1() {

        ts.push(0, 1); ts.push(1, 2); ts.pop(0); ts.push(2, 1); ts.push(0, 3);

        try{
            assertEquals(ts.pop(0), 3);
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}
