package btree;

public class SolutionBuildTree {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode recursion(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR) return null;
        // 获取根节点
        int rootV = preorder[preL];
        int rootVInInorderIndex = searchIndex(inorder, rootV, inL, inR);
        TreeNode root = new TreeNode(preL);
        int leftSize = rootVInInorderIndex - inL;
        // 遍历左子树
        root.left = recursion(preorder, preL + 1, preL + leftSize, inorder, inL, rootVInInorderIndex - 1);
        // 遍历右子树
        root.right = recursion(preorder, preL + leftSize + 1, preR, inorder, rootVInInorderIndex + 1, inR);
        return root;
    }
    private int searchIndex(int[] inorder, int value, int inL, int inR) {
        for (int i = inL; i <= inR; i++) {
            if (inorder[i] == value) return i;
        }
        return -1;
    }
}
