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

    @Ignore
    @Test
    public void test2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);

        n1.add(1); n1.add(2); n1.add(2); n1.add(1);
        n2.add(2);

        try{
            assertEquals(ll.deleteDups1(n1), n2);
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Ignore
    @Test
    public void test3() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);

        n1.add(1); n1.add(2); n1.add(3); n1.add(1); n1.add(3); n1.add(2);
        n2.add(2); n2.add(3);

        try{
            assertEquals(ll.deleteDups2(n1), n2);
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }

    }

    @Ignore
    @Test
    public void test4() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);

        n1.add(2); n1.add(3); n1.add(4); n1.add(5); n1.add(6);

        try{
            assertEquals(ll.nthToLast(n1, 3).equals(n2), true);
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test5() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);

        n1.add(2); n1.add(3); n1.add(4);
        n2.add(3); n2.add(4);

        ll.deleteNodeInTheMiddle(n1.next);
        try{
            assertEquals(n1, n2);
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }


}
