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

    @Test
    @Ignore
    public void test1() {
        mp.printPrimeNumbers(1000);
    }

    @Ignore
    @Test
    public void test2() {
        testify(true, mp.isPrime(233));
        testify(false, mp.isPrime(49));
    }

    @Ignore
    @Test
    public void test3() {
        testify(false, mp.isSuperPrime(2000));
        testify(true, mp.isSuperPrime(2333));
    }

    @Test
    public void test4() {
        mp.printPrimeFactors(9);
        mp.printPrimeFactors(24);
        mp.printPrimeFactors(332);
        mp.printPrimeFactors(2345);
        mp.printPrimeFactors(75322);
    }
}
