import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) {
        this.val = x;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TreeNode) {
            TreeNode t = (TreeNode) obj;
            return equalsHelper(this, t);
            // if (t == null && this == null) {
            //     return true;
            // }
            // if (t != null && this != null && t.val == this.val) {
            //     boolean l, r;
            //     if (t.left == null && this.left == null) {
            //         l = true;
            //     } else if (t.left != null && this.left != null) {
            //         l = this.left.equals(t.left);
            //     } else {
            //         return false;
            //     }
            //     if (t.right == null && this.right == null) {
            //         r = true;
            //     } else if (t.right != null && this.right != null) {
            //         r = this.right.equals(t.right);
            //     } else {
            //         return false;
            //     }
            //     return l && r;
            // }
        }
        return false;
    }

    private boolean equalsHelper(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 != null && n2 != null && n1.val == n2.val) {
            boolean l = equalsHelper(n1.left, n2.left);
            boolean r = equalsHelper(n1.right, n2.right);
            return l && r;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        List<Integer> li = new ArrayList<Integer>();
        toStringHelper(this, li);
        int n = li.size();
        StringBuilder res = new StringBuilder();
        res.append("Preorder: ");
        for (int i = 0; i < n; i++) {
            res.append(li.get(i));
            if (i != n - 1) {
                res.append("-");
            }
        }
        return res.toString();
    }

    private void toStringHelper(TreeNode node, List<Integer> li) {
        if (node == null) {
            return;
        }
        toStringHelper(node.left, li);
        li.add(node.val);
        toStringHelper(node.right, li);
    }

    public void add(int x) {
        if(x == val) {
            TreeNode t = new TreeNode(x);
            t.left = left;
            left = t;
        } else if(x > val) {
            if(right == null) {
                right = new TreeNode(x);
            } else {
                right.add(x);
            }
        } else {
            if(left == null) {
                left = new TreeNode(x);
            } else {
                left.add(x);
            }
        }
    }
}
