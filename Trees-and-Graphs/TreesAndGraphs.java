import java.util.*;

public class TreesAndGraphs {
    public List<Integer> preOrderTraversal(TreeNode root, int method) {
        /*
        method: 1 for recursive, 2 for iterarive
        */
        List<Integer> res = new LinkedList<Integer>();
        if (method == 1) {
            preOrderHelper(root, res);
            return res;
        } else if (method == 2) {
            if (root == null) {
                return res;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode tmp = stack.pop();
                if (tmp.right != null) {
                    stack.push(tmp.right);
                }
                if (tmp.left != null) {
                    stack.push(tmp.left);
                }
                res.add(tmp.val);
            }
            return res;
        } else {
            return res;
        }
    }

    public void preOrderHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrderHelper(root.left, res);
        preOrderHelper(root.right, res);
    }
}
