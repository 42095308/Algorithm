package btree;


public class SolutionSortedArrayToBST {
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
    * 核心思想：利用分治思想，每次选取数组的中点作为树的根
    * 使用先序遍历
    * */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    private static TreeNode recursion(int[] nums, int lIdx, int rIdx) {
        if (lIdx > rIdx) {
            return null;
        }
        int midIdx = lIdx + (rIdx - lIdx) / 2;
        TreeNode node = new TreeNode(nums[midIdx]);
        node.left = recursion(nums, lIdx, midIdx - 1);
        node.right = recursion(nums, midIdx + 1, rIdx);
        return node;
    }

    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }
}
