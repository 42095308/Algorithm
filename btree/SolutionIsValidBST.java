package btree;

import javax.swing.tree.TreeNode;

public class SolutionIsValidBST {
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
    * 核心：使用中序遍历，且需要一个前驱节点
    * */
    private TreeNode preNode = null;
    public boolean isValidBST(TreeNode root) {
        return recursion(root);
    }

    private boolean recursion(TreeNode root) {
        if (root == null) return true;
        if (!recursion(root.left)) {
            return false;
        }

        if (preNode != null && preNode.val >= root.val) {
            return false;
        }
        preNode = root;
        return recursion(root.right);
    }
}
