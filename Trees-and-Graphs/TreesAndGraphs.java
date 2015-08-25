import java.util.*;

public class TreesAndGraphs {
    public void preOrderTraversal(TreeNode root, int method) {
        /*
        method: 1 for recursive, 2 for iterarive
        */
        if (method == 1) {
            if (root != null) {
                System.out.print(" " + root.val);
                preOrderTraversal(root.left, 1);
                preOrderTraversal(root.right, 1);
            }
        }
    }
}
