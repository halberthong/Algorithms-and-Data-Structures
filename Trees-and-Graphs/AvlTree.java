public class AvlTree {
    private AvlNode root;
    public AvlTree() {
        root = null;
    }
    public AvlNode getRoot() {
        return root;
    }
    public AvlNode find(int key, AvlNode foo) {
        if (foo == null) {
            return null;
        } else if (foo.val == key) {
            return foo;
        } else if (foo.val < key) {
            return find(key, foo.right);
        } else {
            return find(key, foo.left);
        }
    }
    public int height(AvlNode node) {
        if (node == null) return -1;
        return node.height;
    }
    public AvlNode rotateWithLeft(AvlNode node) {
        AvlNode p = node.left;
        node.left = p.right;
        p.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        return p;
    }
    public AvlNode rotateWithRight(AvlNode node) {
        AvlNode p = node.right;
        node.right = p.left;
        p.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        return p;
    }
    public AvlNode doubleRotateWithLeft(AvlNode node) {
        AvlNode tmp;
        node.left = rotateWithRight(node.left);
        tmp = rotateWithLeft(node);
        return tmp;
    }
    public AvlNode doubleRotateWithRight(AvlNode node) {
        AvlNode tmp;
        node.right = rotateWithLeft(node.right);
        tmp = rotateWithRight(node);
        return tmp;
    }

    public AvlNode avlInsert(AvlNode newNode, AvlNode par) {
        AvlNode newPar = par;
        if (newNode.val < par.val) {
            if (par.left == null) {
                par.left = newNode;
            } else {
                par.left = avlInsert(newNode, par.left);
                if (height(par.left) - height(par.right) == 2) {
                    if (newNode.val < par.left.val) {
                        newPar = rotateWithLeft(par);
                    } else {
                        newPar = doubleRotateWithLeft(par);
                    }
                }
            }
        } else if (newNode.val > par.val) {
            if (par.right == null) {
                par.right = newNode;
            } else {
                par.right = avlInsert(newNode, par.right);
                if (height(par.right) - height(par.left) == 2) {
                    if (newNode.val > par.right.val) {
                        newPar = rotateWithRight(par);
                    } else {
                        newPar = doubleRotateWithRight(par);
                    }
                }
            }
        } else {
            System.out.println("Duplicate Key");
        }
        if ((par.left == null) && (par.right != null))
            par.height = par.right.height + 1;
        else if ((par.right == null) && (par.left != null))
            par.height = par.left.height + 1;
        else
            par.height = Math.max(height(par.left), height(par.right)) + 1;
        return newPar;
    }
    public void insert(int id) {
        AvlNode newNode = new AvlNode(id);
        if (root == null) {
            root = newNode;
        } else {
            root = avlInsert(newNode, root);
        }
    }
}

class AvlNode {
    public int val;
    public int height;
    public AvlNode left;
    public AvlNode right;
    public AvlNode(int data) {
        val = data;
        height = 0;
        left = null;
        right = null;
    }
}
