package greed;

import java.util.Arrays;

public class SolutionJump {
    /*
    * 注意：题目说明一定可以跳到n-1位置
    * */
    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1, nums.length, nums.length - 1);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}
