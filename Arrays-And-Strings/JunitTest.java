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

    @Ignore
    @Test
    public void test4() {
        String[] s = {null, new String(), "a", "aaa", "abc", "aaabbb", "ababab", "aswwssaass"};
        String[] t = {null, new String(), "a", "a", "bac", "abbbaa", "abaaab", "asssasasww"};
        boolean[] results = {false, true, true, false, true, true, false, true};
        for(int i = 0; i < s.length; i++) {
            try{
                assertEquals("\n Test Failure of isAnagram: \nInput: " + s[i] + " , " + t[i] + "\n", results[i], as.isAnagram(s[i], t[i]));
            } catch(AssertionError e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Ignore
    @Test
    @SuppressWarnings("deprecation")
    public void test5() {
        int[][][] matrices = {null, {{1}}, {{1, 2}, {3, 4}}, {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}}};
        int[][][] results = {null, {{1}}, {{3, 1}, {4, 2}}, {{13,9,5,1}, {14,10,6,2}, {15,11,7,3}, {16,12,8,4}}};
        for(int i = 0; i < matrices.length; i++) {
            try{
                assertEquals("\n Test Failure of rotateMatrix: \nInput: Matrix #" + i + "\n", results[i], as.rotateMatrix(matrices[i]));
            } catch(AssertionError e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Ignore
    @Test
    @SuppressWarnings("deprecation")
    public void test6() {
        int[][][] matrices = {null, {{1}}, {{0, 1}, {1, 1}}, {{0,1,1}, {1,0,1}, {1,1,1}}};
        int[][][] results = {null, {{1}}, {{0, 0}, {0, 1}}, {{0,0,0}, {0,0,0}, {0,0,1}}};
        for(int i = 0; i < matrices.length; i++) {
            try{
                assertEquals("\n Test Failure of setZeros: \nInput: Matrix #" + i + "\n", results[i], as.setZeros(matrices[i]));
            } catch(AssertionError e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Ignore
    @Test
    public void test7() {
        String[] s = {null, new String(), "a", "a", "abc", "aab", "aab"};
        String[] t = {null, new String(), "a", "abc", "abacab", "aaccaabbaa", "aaab"};
        boolean[] results = {false, true, true, true, false, true, true};
        for(int i = 0; i < s.length; i++) {
            try{
                assertEquals("\n Test Failure of isSubstring: \nInput: " + s[i] + " , " + t[i] + "\n", results[i], as.isSubstring(s[i], t[i]));
            } catch(AssertionError e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Ignore
    @Test
    public void test8() {
        String[] s = {null, new String(), "a", "bca", "deabc", "decde"};
        String[] t = {null, new String(), "a", "abc", "abcde", "abcde"};
        boolean[] results = {false, true, true, true, true, false};
        for(int i = 0; i < s.length; i++) {
            try{
                assertEquals("\n Test Failure of isRotation: \nInput: " + s[i] + " , " + t[i] + "\n", results[i], as.isRotation(s[i], t[i]));
            } catch(AssertionError e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Ignore
    @Test
    public void test9() {
        int[][] arr1 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        as.printReverseDiagonal(arr1);
        int[][] arr2 = {{1,2,3}, {4,5,6}, {7,8,9}};
        as.printReverseDiagonal(arr2);
        int[][] arr3 = {{1,2}, {3,4}, {5,6}};
        as.printReverseDiagonal(arr3);
    }

    @Ignore
    @Test
    public void test10() {
        System.out.println(as.atoi("-123 3"));
    }

    @Test
    public void test11() {
        int[] a1 = {8,0,1};
        int[] a2 = {3,9,9};
        printArray(as.addTwoNumbers(a1, a2));
    }
    private void printArray(int[] arr) {
        for(int tmp : arr) {
            System.out.print(tmp + " ");
        }
    }
}
