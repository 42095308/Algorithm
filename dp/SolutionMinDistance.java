package dp;

public class SolutionMinDistance {
    /*
    * 核心思想：本题与最长公共子序列很像，都是两个对象（也就是两个字符串），即一个维度表示一个字符串
    * */
    public int minDistance(String word1, String word2) {
        //if (word1.isEmpty()) return word2.length();
        //if (word2.isEmpty()) return word1.length();
        int l1 = word1.length();
        int l2 = word2.length();
        // dp[i][j]：表示0到i的串，转变为0到j的串需要的最少次数
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 当前字符相同的话，直接继承之前的结果即可
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 如果不同的话，就看三种操作方式，哪一种能够使得次数最少
                    /*
                    * 核心：+1表示此次处理操作用的次数（三种都相同），接着就看处理完之后，还剩下多少个字符待处理
                    * */
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[l1][l2];
    }
}
