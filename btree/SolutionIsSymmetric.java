package btree;

import javax.swing.tree.TreeNode;

public class SolutionIsSymmetric {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recursion(root.left, root.right);
    }

    private boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        boolean leftBool = recursion(left.left, right.right);
        boolean rightBool = recursion(left.right, right.left);
        return leftBool && rightBool;
    }
}
