package greed;

public class SolutionCanJump {
    /*
    * 使用动态规划算法解决
    * */
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]) { // 查找安全点
                    if (j+ nums[j] >= i) {
                        dp[i] = true;
                        // 找到一个安全点可以到达该位置后，直接退出，防止结果被覆盖
                        break;
                    }
                }
            }
        }
        return dp[nums.length - 1];
    }
}
