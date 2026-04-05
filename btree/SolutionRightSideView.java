package btree;

import java.util.ArrayList;
import java.util.List;

public class SolutionRightSideView {
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
    * bfs：借助队列，每次先添加右节点，结果集中存入队列中的第一个节点
    * dfs：借助深度，中右左顺序，当结果集的大小与深度一致时，存入结果
    * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        recursion(root, ret, 0);
        return ret;
    }

    private void recursion(TreeNode root, List<Integer> ret, int depth) {
        if (root == null) return;
        if (depth == ret.size()) { // 这个判断是核心
            ret.add(root.val);
        }
        recursion(root.right, ret, depth + 1);
        recursion(root.left, ret, depth + 1);
    }
}
