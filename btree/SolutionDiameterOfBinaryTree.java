package btree;


public class SolutionDiameterOfBinaryTree {
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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return maxDiameter;
    }

    private int recursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = recursion(root.left);
        int rightDepth = recursion(root.right);
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
