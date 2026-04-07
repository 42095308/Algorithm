package dp;

public class SolutionLongestValidParentheses {
    /*
     * 核心思路：和单词拆分的思路很像（找安全点的步数取决于单词的长度）。本题找安全点的步数取决于嵌套的深度
     * */
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        int maxValue = 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == ')' ) { // 当前括号（凡是处理括号相关的题，找右括号都是首选）
                if (s.charAt(i - 2) == '(') { // 处理最简单的情况：（）
                    dp[i] = dp[i - 2] + 2;
                } else {
                    // 处理嵌套括号：（（））
                    int preSafePoint = dp[i - 1];
                    int lookLeftSafeIndex = i - preSafePoint - 2;
                    if (lookLeftSafeIndex >= 0 && s.charAt(lookLeftSafeIndex) == '(') {
                        // 必须加上lookLeftSafeIndex处的preSafePoint，因为最大长度不会给 ( 存着
                        dp[i] = preSafePoint + 2 + dp[lookLeftSafeIndex];
                    }
                }
            }
            maxValue = Math.max(dp[i], maxValue);
        }
        return maxValue;
    }
}
