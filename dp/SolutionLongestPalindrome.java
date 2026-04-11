package dp;

public class SolutionLongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int len = s.length();
        // dp[i][j]：表示从i到j的字串是否是回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true; // 赋初始值
        }
        int maxLen = 1;
        int beginIndex = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)) { // 表示以j为起点，i为终点的首尾串已经是回文
                    if (i - j < 2 || dp[j + 1][i - 1]) {
                        dp[j][i] = true; // 表示j与i之间相差一个字符或没有字符。或者是j+1与i-1的子串已经是回文了
                    }
                }
                // 表示以j为起点，i为终点的首尾串不是回文，即j向前走即可
                if (dp[j][i] && i - j > maxLen) {
                    maxLen = i - j+ 1;
                    beginIndex = j;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLen);
    }
}
