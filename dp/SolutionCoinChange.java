package dp;

import java.util.Arrays;

public class SolutionCoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // dp[i]表示金额i，需要最少的硬币数量
        // 就算是有一元硬币，也不可能使amount需要的硬币数为amount+1，这样设置是为了再返回的时候进行判断，防止amount真的只是amount个硬币个数
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) { // 遍历硬币种类
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); // +1表示的是一个硬币，并不是具体的数额
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
