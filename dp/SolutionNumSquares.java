package dp;

import java.util.Arrays;

public class SolutionNumSquares {
    /*
    * 核心思想：完全平方数该怎么进行表示？使用循环，即平方数为i * i
    * */
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // dp[i]表示和为i的最少平方数的数量
        // 初始化：每一个dp[i]都应该给一个上限
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 任何一个数都可以由n个1组成
        }
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // +1是因为每次都跳到前一个平方数的格子（i - j * j 有点类似两数之和，根据差值查找hash）
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 和自身比较是因为dp[i]已经被赋初始值了
            }
        }
        return dp[n];
    }
}
