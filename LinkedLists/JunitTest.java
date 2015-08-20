import static org.junit.Assert.assertEquals;
import org.junit.*;
import java.util.*;

public class JunitTest {
    /*
    Add @Ignore before @Test if you don't run the test case
    */

    static LinkedLists ll;

    @BeforeClass
    public static void oneTimeSetUp() {
        ll = new LinkedLists();
    }

    @Test
    public void test2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);

        n1.add(1);

        try{
            assertEquals(ll.deleteDups(n1).toString(), n2.toString());
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }

    }

}
