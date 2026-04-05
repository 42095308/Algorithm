package btree;


public class SolutionFlatten {
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
    /*
    * 遍历顺序应该是：右左根
    * */
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        recursion(root);
    }

    private void recursion(TreeNode root) {
        if (root == null) return;
        recursion(root.right);
        recursion(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
