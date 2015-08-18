import static org.junit.Assert.assertEquals;
import org.junit.*;

public class JunitTest {

    String[] inputs = {null, "abc", "aaaa", "aaabbb", "ababab"};
    boolean[] results = {true, true, false, false, false};
    static Arrays_and_Strings as;

    @BeforeClass
    public static void oneTimeSetUp() {
        as = new Arrays_and_Strings();
    }

    @Test
    public void evaluate() throws Exception{
        for(int i = 0; i < inputs.length; i++) {
            assertEquals(results[i], as.noDuplocateString1(inputs[i]));
            assertEquals(results[i], as.noDuplocateString2(inputs[i]));
        }
    }
}
