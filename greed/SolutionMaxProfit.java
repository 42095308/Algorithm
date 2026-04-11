package greed;

public class SolutionMaxProfit {
    /*public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length == 1) return maxProfit;
        for (int i = 0; i < prices.length; i++) { // 卖出
            int profit = 0;
            for (int j = 0; j <= i; j++) { // 买入
                profit = prices[i] - prices[j];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }*/

    /*
    * 使用动态规划
    * */
    /*public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2]; // 使用二维数组表示状态 0表示没有持有股票，1表示持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }*/


    /*
     * 使用贪心算法（可将原问题分解，每个阶段的结果不会产生依赖性）
     * */
    public static int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int minBuyPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minBuyPrice = Math.min(prices[i], minBuyPrice);
            maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
