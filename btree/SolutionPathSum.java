package btree;


import java.util.HashMap;
import java.util.Map;

public class SolutionPathSum {
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
    * 暴力搜索：每次遇到一个新节点，就以当前节点为根节点开始搜索
    * */
    /*
    * 主循环：用于遍历树中每一个节点
    * */
    //public int pathSum(TreeNode root, int targetSum) {
    //    if (root == null) return 0;
    //    int res = rootSum(root, (long) targetSum);
    //    res += pathSum(root.left, targetSum);
    //    res += pathSum(root.right, targetSum);
    //    return res;
    //}
    //// 返回值：以当前节点为根节点的路径总数
    //private int rootSum(TreeNode root, long targetSum) {
    //    if (root == null) return 0;
    //    int count = 0; // 最上层的count，即最终结果
    //    if (root.val == targetSum) {
    //        count++;
    //    }
    //    // 即使成功也要继续向下递归，因为val可能是0或者是负数
    //    count += rootSum(root.left, targetSum - root.val);
    //    count += rootSum(root.right, targetSum - root.val);
    //    return count;
    //}

    /*
    * 进阶思路：使用前缀和+hash（类似leetcode的 和为k的子数组）
    * hash：key（当前节点的前缀和） value（指定前缀和出现的次数）
    * */
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); // 将当前
        return recursion(root, preSum, targetSum, 0);
    }

    private int recursion(TreeNode root, Map<Integer, Integer> preSum, int targetSum, int curSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        curSum += root.val;
        res += preSum.getOrDefault(curSum - targetSum, 0);
        // 将当前节点的前缀和加入preSum
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        res += recursion(root.left, preSum, targetSum, curSum);
        res += recursion(root.right, preSum, targetSum, curSum);
        // 回溯：当前节点的左右子树都执行完之后，将当前节点的前缀和去除
        preSum.put(curSum, preSum.get(curSum) - 1);
        return res;
    }
}
