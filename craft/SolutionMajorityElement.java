package craft;

public class SolutionMajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        // 核心思想：摩尔投票算法
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            if (candidate == num) count++;
            else count--;
        }
        return candidate;
    }
}
