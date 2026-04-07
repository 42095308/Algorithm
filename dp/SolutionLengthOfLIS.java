package dp;

import java.util.Arrays;

public class SolutionLengthOfLIS {
    /*public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxV = 1;
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int curV = nums[i];
            int max = 0;
            while (j >= 0) {
                if (nums[j] >= curV) {
                    j--;
                } else {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                    j--;
                }
            }
            dp[i] = Math.max(max, dp[i]);
            maxV = Math.max(maxV, dp[i]);
        }
        return maxV;
    }*/

    /*
    * 使用贪心+二分优化，复杂度O(NlogN)
    * 核心思想：每碰见一个小的数就将其留下，为后续的子序列的长度增加潜力
    * */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        // tail[i] 表示以以tail[i]结尾的最长子序列为i
        int[] tail =  new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int i = 0;
            int j = size;
            while (i < j) {
                int mid = i + (j - i) / 2;
                if (tail[mid] < num) i = mid + 1;
                else j = mid;
            }
            tail[i] = num;
            if (i == size) size++;
        }
        return size;
    }
}
