package graph;

public class SolutionTrie {
    class Trie {
        private static class TreeNode {
            private TreeNode[] children = new TreeNode[26];
            private boolean isEnd = false;
            public TreeNode() {}
            public TreeNode(char c, boolean isEnd) {
                this.isEnd = isEnd;
                this.children[c - 'a'] = new TreeNode();
            }
        }
        private TreeNode root = null;
        public Trie() {
            root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                // 使用路径的边表示字符，而不是分支节点
                if (cur.children[word.charAt(i) - 'a'] == null) {
                    cur.children[word.charAt(i) - 'a'] = new TreeNode();
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            TreeNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            return cur.isEnd;
        }

        public boolean startsWith(String prefix) {
            TreeNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (cur.children[prefix.charAt(i) - 'a'] == null) {
                    return false;
                }
                cur = cur.children[prefix.charAt(i) - 'a'];
            }
            return true;
        }
    }
}
