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
    public void print(Object obj) {
        System.out.println(obj.toString());
    }

    @Ignore
    @Test
    public void test1() {
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        t2.add(1);
        t2.add(10);
        testify(t1, t2);
    }

    @Ignore
    @Test
    public void test2() {
        TreeNode t1 = new TreeNode(3);
        t1.add(1); t1.add(2); t1.add(4); t1.add(5);
        testify(tg.preOrderTraversal(t1, 1), tg.preOrderTraversal(t1, 2));
    }

    @Ignore
    @Test
    public void test3() {
        TreeNode t1 = new TreeNode(3);
        t1.add(1); t1.add(2); t1.add(4); t1.add(5);
        testify(tg.inOrderTraversal(t1, 1), tg.inOrderTraversal(t1, 2));
    }

    @Ignore
    @Test
    public void test4() {
        TreeNode t1 = new TreeNode(3);
        t1.add(1); t1.add(2); t1.add(4); t1.add(5);
        testify(true, tg.isBalancedTree(t1));
    }

    @Ignore
    @Test
    public void test5() {
        TreeNode t1 = new TreeNode(4);
        t1.add(2); t1.add(1); t1.add(3); t1.add(6); t1.add(5); t1.add(7);
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode t2 = tg.arrayToBST(arr);
        System.out.println(t2);
        testify(t1, t2);
    }

    @Ignore
    @Test
    public void test6() {
        char[][] m1 = {{'0', '0', '0', '0'}, {'G', 'B', 'G', 'G'}, {'0', '0', '0', 'G'}};
        printMatrix(m1);
        printMatrix(tg.getShortestPath(m1));
    }
    private void printMatrix(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    @Test
    public void test7() {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(40);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(15);
        print(tg.isBanlancedWeightedTree(root));
    }
}
