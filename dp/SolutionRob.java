package dp;

public class SolutionRob {
    /*
    * 核心：不能抢相邻两件房屋
    * */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1]; // dp[i]表示抢夺完第i间房屋后的最大金额
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }
}
