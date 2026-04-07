package dp;

import java.util.Arrays;

public class SolutionCanPartition {
    /*
    * 难点：该怎么去简化问题，将其看成是一个配重问题即可
    * */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2== 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        // 将物品放在外层循环且使用倒序遍历，就保证了每一个物品只会使用一次
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,2,5}));
    }
}
