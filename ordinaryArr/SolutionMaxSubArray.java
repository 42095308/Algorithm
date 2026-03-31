package ordinaryArr;

public class SolutionMaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        // 使用动态规划思想
        int[] dp = new int[nums.length]; // dp[i]表示从0-i的最大子数组和
        dp[0] = nums[0];
        int ret = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            ret = Math.max(dp[i], ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
