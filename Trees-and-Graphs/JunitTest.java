import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;

public class JunitTest {
    /*
    Add @Ignore before @Test if you don't run the test case
    */
    public static TreesAndGraphs tg;

    @BeforeClass
    public static void oneTimeSetUp() {
        tg = new TreesAndGraphs();
    }

    @Ignore
    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);
        t1.display();
        try{
            assertEquals(t1, t2);
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test2() {
        TreeNode t1 = new TreeNode(3);
        t1.add(1); t1.add(2); t1.add(4); t1.add(5);
        t1.display();
        tg.preOrderTraversal(t1, 1);
    }
}
