import static org.junit.Assert.assertEquals;
import org.junit.*;

public class JunitTest {
    /*
    Add @Ignore before @Test if you don't run the test case
    */

    static ArraysAndStrings as;

    @BeforeClass
    public static void oneTimeSetUp() {
        as = new ArraysAndStrings();
    }

    @Ignore
    @Test
    public void test1() {
        String[] inputs = {null, new String(), "abc", "aaaa", "aaabbb", "ababab"};
        boolean[] results = {true, true, true, false, false, false};
        for(int i = 0; i < inputs.length; i++) {
            assertEquals(results[i], as.noDuplocateString1(inputs[i]));
            assertEquals(results[i], as.noDuplocateString2(inputs[i]));
        }
    }

    @Ignore
    @Test
    public void test2() {
        String[] in = {null, new String(), "a", "aaa", "abc", "aab"};
        String[] out = {null, new String(), "a", "aaa", "cba", "baa"};
        for(int i = 0; i < in.length; i++) {
            assertEquals(out[i], as.reverseString(in[i]));
        }
    }

    @Ignore
    @Test
    public void test3() {
        String[] in = {null, new String(), "a", "aaa", "abc", "aaabbb", "ababab"};
        String[] out = {null, new String(), "a", "a", "abc", "ab", "ab"};
        for(int i = 0; i < in.length; i++) {
            assertEquals(out[i], as.removeDuplicates(in[i]));
        }
    }

    @Test
    public void test4() {
        String[] s = {null, new String(), "a", "aaa", "abc", "aaabbb", "ababab", "aswwssaass"};
        String[] t = {null, new String(), "a", "a", "bac", "abbbaa", "abaaab", "asssasasww"};
        boolean[] results = {false, true, true, false, true, true, false, true};
        for(int i = 0; i < s.length; i++) {
            try{
                assertEquals("\n Test Failure: Input: " + s[i] + " , " + t[i] + "\n", results[i], as.isAnagram(s[i], t[i]));
            } catch(AssertionError e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
