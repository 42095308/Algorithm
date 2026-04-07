package dp;

public class SolutionClimbStairs {
    /*
    * 楼梯只能爬1层或者两层，即可由此推出转移方程
    * */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
