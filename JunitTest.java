import static org.junit.Assert.assertEquals;
import org.junit.*;

public class JunitTest {

    String[] inputs = {null, "abc", "aaaa", "aaabbb", "ababab"};
    boolean[] results = {true, true, false, false, false};
    static ArraysAndStrings as;

    @BeforeClass
    public static void oneTimeSetUp() {
        as = new ArraysAndStrings();
    }

    @Test
    public void evaluate() throws Exception{
        for(int i = 0; i < inputs.length; i++) {
            assertEquals(results[i], as.noDuplocateString1(inputs[i]));
            assertEquals(results[i], as.noDuplocateString2(inputs[i]));
        }
    }
}
