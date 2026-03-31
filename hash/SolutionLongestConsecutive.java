package hash;

import java.util.HashMap;
import java.util.HashSet;

public class SolutionLongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        int ret = 0;
        if (nums.length == 0) {
            return ret;
        }
        // 跳过数组中重复的元素
        HashSet<Integer> tempSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            tempSet.add(nums[i]);
        }
        int temp = 0;
        int sumTemp = 0;
        for (int i : tempSet) {
            // x-1肯定比x的子序列长
            if (tempSet.contains(i - 1)) continue;
            temp++;
            sumTemp = i + 1;
            while (tempSet.contains(sumTemp)) {
                temp++;
                sumTemp += 1;
            }
            ret = Math.max(temp, ret);
            temp = 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
