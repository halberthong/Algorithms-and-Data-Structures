import static org.junit.Assert.assertEquals;
import org.junit.*;

public class JunitTest {
    /*
    Add @Ignore before @Test if you don't run the test case
    */

    static StacksAndQueues sq;

    @BeforeClass
    public static void oneTimeSetUp() {
        sq = new StacksAndQueues();
    }
}
