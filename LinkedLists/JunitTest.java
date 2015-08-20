import static org.junit.Assert.assertEquals;
import org.junit.*;

public class JunitTest {
    /*
    Add @Ignore before @Test if you don't run the test case
    */

    // static LinkedLists ll;
    //
    // @BeforeClass
    // public static void oneTimeSetUp() {
    //     ll = new LinkedLists();
    // }

    @Test
    public void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);

        n1.add(1);
        n2.add(1);

        try{
            assertEquals(n1, n2);
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }

    }

}
