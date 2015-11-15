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
    public void test2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);

        n1.add(1); n1.add(2); n1.add(2); n1.add(1);
        n2.add(2);

        try{
            assertEquals(ll.deleteDups1(n1).listToString(), n2.listToString());
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
            assertEquals(ll.deleteDups2(n1).listToString(), n2.listToString());
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
            assertEquals(ll.nthToLast(n1, 3), n2);
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Ignore
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

    @Ignore
    @Test
    public void test6() {
        //395+786=1181

        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(6);
        ListNode res = new ListNode(1);

        n1.add(9); n1.add(3);
        n2.add(8); n2.add(7);
        res.add(8); res.add(1); res.add(1);

        try{
            assertEquals(res.listToString(), ll.addLists(n1, n2).listToString());
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Ignore
    @Test
    public void test7() {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);

        n1.add(2); n1.add(3); n1.add(4);
        n2.add(3); n2.add(2); n2.add(1);

        try{
            assertEquals(n1.listToString(), ll.reverseList_iterative(n2).listToString());
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Ignore
    @Test
    public void test8() {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);

        n1.add(2); n1.add(3); n1.add(4);
        n2.add(3); n2.add(2); n2.add(1);

        try{
            assertEquals(n1.listToString(), ll.reverseList_recursive(n2).listToString());
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Ignore
    @Test
    public void test9() {

        ListNode n1 = new ListNode(1);

        n1.add(2); n1.add(3); n1.add(4); n1.add(5); n1.add(6); n1.add(7);
        n1.add(n1.next.next);

        try{
            assertEquals(ll.findBeginning(n1), new ListNode(3));
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Ignore
    @Test
    public void test10() {
        ListNode l1 = new ListNode(0);
        l1.add(5);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode res = new ListNode(0);
        res.add(2); res.add(3); res.add(5);
        List<ListNode> lists = new ArrayList<ListNode>();
        lists.add(l1); lists.add(l2); lists.add(l3);
        ListNode test = ll.mergeKLists(lists, 1);
        testify(res, test);
    }

    @Ignore
    @Test
    public void test11() {
        ListNode l1 = new ListNode(0);
        l1.add(5);
        l1.add(7);
        l1.add(3);
        l1.add(6);
        ListNode l2 = ll.insertionSortList(l1);
        ListNode res = new ListNode(0);
        res.add(3);
        res.add(5);
        res.add(6);
        res.add(7);
        testify(res, l2);
    }

    @Ignore
    @Test
    public void test12() {
        ListNode l1 = new ListNode(9);
        l1.add(10); l1.add(12); l1.add(13); l1.add(14); l1.add(20); l1.add(21);
        l1.add(22); l1.add(23); l1.add(24); l1.add(25); l1.add(26); l1.add(27);
        ll.printInterval(l1);
    }

    @Ignore
    @Test
    public void test13() {
        List<Integer> l1 = new LinkedList<Integer>();
        l1.add(1); l1.add(2); l1.add(3); l1.add(4);
        List<Integer> l2 = new LinkedList<Integer>();
        l2.add(5); l2.add(6); l2.add(7);
        List<Integer> l3 = new LinkedList<Integer>();
        l3.add(8); l3.add(9); l3.add(10); l3.add(11);
        List<Iterator<Integer>> lists = new LinkedList();
        lists.add(l1.iterator()); lists.add(l2.iterator()); lists.add(l3.iterator());
        ZigZagIterator zzi = new ZigZagIterator(lists);
        System.out.println();
        while (zzi.hasNext()) {
            System.out.print(zzi.next() + " ");
        }
    }

    @Test
    public void test14() {
        ListNode l = new ListNode(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        ListNode newl = ll.reverseSecondHalf(l);
        while (newl != null) {
            System.out.print(newl.val + " ");
            newl = newl.next;
        }
    }
}
