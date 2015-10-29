import java.util.*;

public class TreesAndGraphs {
    /* Pre Order Traversal */
    public List<Integer> preOrderTraversal(TreeNode root, int method) {
        /* method: 1 for recursive, 2 for iterarive */
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

    private void preOrderHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrderHelper(root.left, res);
        preOrderHelper(root.right, res);
    }

    /* In Order Traversal */
    public List<Integer> inOrderTraversal(TreeNode root, int method) {
        /* method: 1 for recursive, 2 for iterarive */
        List<Integer> res = new LinkedList<Integer>();
        if (method == 1) {
            inOrderHelper(root, res);
            return res;
        } else if (method == 2) {
            if (root == null) {
                return res;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        } else {
            return res;
        }
    }

    private void inOrderHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrderHelper(root.left, res);
        res.add(root.val);
        inOrderHelper(root.right, res);
        return;
    }

    /*
    Implement a function to check if a tree is balanced.
    Meaning no two leaf nodes differ in distance from the root by more than one.
    */
    public boolean isBalancedTree(TreeNode root) {
        return maxDepth(root) - minDepth(root) <= 1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /*
    Create a balanced BST by a sorted array
    */
    public TreeNode arrayToBST(int[] arr) {
        if (arr == null) {
            return null;
        }
        return arrayToBSTHelper(arr, 0, arr.length - 1);
    }

    private TreeNode arrayToBSTHelper(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = arrayToBSTHelper(arr, start, mid - 1);
        root.right = arrayToBSTHelper(arr, mid + 1, end);
        return root;
    }

    public char[][] getShortestPath(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited = new int[m][n];
        int flag = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'G') {
                    getShortestPathDFS(matrix, flag, visited, i + 1, j, 1);
                    getShortestPathDFS(matrix, flag, visited, i, j + 1, 1);
                    getShortestPathDFS(matrix, flag, visited, i - 1, j, 1);
                    getShortestPathDFS(matrix, flag, visited, i, j - 1, 1);
                    flag++;
                }
            }
        }
        return matrix;
    }
    private void getShortestPathDFS(char[][] matrix, int flag, int[][] visited, int i, int j, int level) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return;
        if (matrix[i][j] != 'G' && matrix[i][j] != 'B' && visited[i][j] != flag) {
            visited[i][j] = flag;
            if (matrix[i][j] == '0' || (matrix[i][j] > level + '0')) {
                matrix[i][j] = (char)(level + '0');
            }
            getShortestPathDFS(matrix, flag, visited, i + 1, j, level + 1);
            getShortestPathDFS(matrix, flag, visited, i, j + 1, level + 1);
            getShortestPathDFS(matrix, flag, visited, i - 1, j, level + 1);
            getShortestPathDFS(matrix, flag, visited, i, j - 1, level + 1);
        }
    }

    public boolean isBanlancedWeightedTree(TreeNode root) {
        return getDepth(root) != -1;
    }
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
