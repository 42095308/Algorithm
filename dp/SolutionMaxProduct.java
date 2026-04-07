package dp;

public class SolutionMaxProduct {
    /*
    * 不能用一维dp，因为子数组的起始位置可能是任意处
    * */
/*    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[][] dp = new int[nums.length][nums.length]; // dp[i][j]表示i-j的最大连续子数组乘积
        // 赋初始值
        int maxAbs = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) dp[i][i] = nums[i];
                else {
                    // 会存入非常多的无用的结果（但是只用到了当前行的结果，因此可以降维）
                    dp[i][j] = dp[i][j - 1] * nums[j];
                }
                // 因为数组中可能会存在复数，所以使用全局变量，随时记录最大值
                maxAbs = Math.max(maxAbs, dp[i][j]);
            }
        }
        return maxAbs;
    }*/

    /*
    * dp[i][j] = dp[i][j - 1] * nums[j]; 会存入非常多的无用的结果（但是只用到了当前行的结果，因此可以降维）
    * */
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dpMax = new int[nums.length]; // dpMax[i]表示
        int[] dpMin = new int[nums.length]; // 必须再要一个记录最小值的数组（因为负数的问题）
        // 对其进行赋初始值
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int MaxV = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curV = nums[i];
            /*
            * dp[i] 的值取决于 dp[i - 1] * curV 与 curV 的值，所以必是连续子数组
            * */
            dpMax[i] = Math.max(dpMax[i - 1] * curV, Math.max(curV, dpMin[i - 1] * curV));
            dpMin[i] = Math.min(dpMax[i - 1] * curV, Math.min(curV, curV * dpMin[i - 1]));
            MaxV = Math.max(MaxV, dpMax[i]);
        }
        return MaxV;
    }
}
