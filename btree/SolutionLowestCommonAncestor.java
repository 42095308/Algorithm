package btree;



public class SolutionLowestCommonAncestor {
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
    * 题目思路：首先需要认真看题干（p、q均在树中），需要知道什么时候才算找到了p、q
    * 使用后序遍历
    * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 只要有一个目标被找到，直接返回（root == null时，返回root是为了简写代码）
        if (root == null || root == p || root == q) return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        // 如果左右子树有一个返回值为null，则表示先找到了其中一个，而另一个是该目标的后代
        if (leftNode != null && rightNode != null) return root;
        return leftNode == null ? rightNode : leftNode;
    }
}
