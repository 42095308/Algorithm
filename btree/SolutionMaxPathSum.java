package btree;


public class SolutionMaxPathSum {
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
    * 本题类似求树的最大宽度
    * */
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recursion(root);
        return maxSum;
    }

    private int recursion(TreeNode root) {
        if (root == null) return 0;
        int leftMaxSum = Math.max(recursion(root.left), 0); // 如果左子树的贡献小于等于0，直接舍弃
        int rightMaxSum = Math.max(recursion(root.right), 0);
        // 遍历整棵树的过程中，同时记录出现的最大值
        maxSum = Math.max(maxSum, leftMaxSum + rightMaxSum + root.val);
        // 必须要加上root.val，因为这相当于桥梁（不需要考虑从root.val是正是负，因为左右子树的值都被记录过）
        return root.val + Math.max(leftMaxSum, rightMaxSum);
    }
}
