import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;

public class JunitTest {
    /*
    Add @Ignore before @Test if you don't run the test case
    */
    public static MathProblems mp;
    @BeforeClass
    public static void oneTimeSetUp() {
        mp = new MathProblems();
    }

    @Test
    @Ignore
    public void test1() {
        mp.printPrimeNumbers(1000);
    }
}
