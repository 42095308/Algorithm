package substr;

import java.util.HashMap;

public class SolutionSubarraySum {
    public static int subarraySum(int[] nums, int k) {
        // 本题是两数之和的变体
        // 初始工作，生成一个前缀和数组
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        tempMap.put(0, 1); // 处理数组中只有一个元素，且该元素为k时的特殊情况
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            int sub = preSum[i] - k;
            if (tempMap.containsKey(sub)) {
                ret += tempMap.get(sub);
            }
            tempMap.put(preSum[i], tempMap.getOrDefault(preSum[i], 0) + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
}
