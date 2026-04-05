package btree;


public class SolutionKthSmallest {
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
    * 思路：中序遍历+访问次数记录
    * */
    private int curIndex = 0;
    public int kthSmallest(TreeNode root, int k) {
        return recursion(root, k);
    }

    private int recursion(TreeNode root, int k) {
        if (root == null) return -1;
        int leftVal = recursion(root.left, k);
        if (leftVal != -1) return leftVal;
        curIndex++;
        // 如果回溯的过程中发现目标值，立刻返回
        if (k == curIndex) return root.val;
        return recursion(root.right, k);
    }
}
