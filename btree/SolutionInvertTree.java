package btree;


public class SolutionInvertTree {
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
    public TreeNode invertTree(TreeNode root) {
        return recursion(root);
    }

    private TreeNode recursion(TreeNode root) {
        if (root == null) return null;
        TreeNode leftNode = recursion(root.left);
        TreeNode rightNode = recursion(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
