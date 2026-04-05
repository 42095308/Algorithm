package btree;

import javax.swing.tree.TreeNode;
import java.util.*;

public class SolutionLevelOrder {
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
    * 二叉树的层序遍历：使用队列即可
    * 核心难点：怎么判断队列中的节点都是同一层的？使用size计数即可
    * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = null;
        if (root == null) return ret;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            path = new ArrayList<>();
            int curSize = queue.size();
            while (curSize > 0) {
                // 需要看看源码，Deque默认是栈的形式
                TreeNode curNode = queue.removeLast();
                path.add(curNode.val);
                if (curNode.left != null) {
                    queue.push(curNode.left);
                }
                if (curNode.right != null) {
                    queue.push(curNode.right);
                }
                curSize--;
            }
            ret.add(path);
        }
        return ret;
    }
}
