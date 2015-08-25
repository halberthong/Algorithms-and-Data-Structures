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
            if(t.val == this.val) {
                boolean res = false;
                if(t.left != null && this.left != null) {
                    res = t.left.equals(this.left);
                }
                if(res && t.right != null && this.right != null) {
                    res = t.right.equals(this.right);
                }
                if(t.left == null && t.right == null && this.left == null && this.right == null){
                    res = true;
                }
                return res;
            }
        }
        return false;
    }

    public void display() {
        if(this != null) {
            System.out.print(val);
            if(left != null) {
                System.out.print("(");
                left.display();
            }
            if(right != null) {
                System.out.print(",");
                right.display();
                System.out.print(")");
            }
        }
    }
}
