package dp;

public class SolutionLongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        // dp[i][j]：表示text1从0-i与text2从0-j的最长公共子序列
        int[][] dp = new int[l1 + 1][l2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 表示如果当前字符相同，则最长子序列取决于0到i-1，0到j-1的最长子序列长度
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 两个字符串第一个字符不相同，则需要舍弃（子序列可以不连续）
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
