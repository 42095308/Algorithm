package hash;

import java.util.Arrays;
import java.util.HashMap;

public class SolutionTwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        if (nums.length == 0) {
            return ret;
        }
        HashMap<Integer, Integer> tempRet = new HashMap<>();
        tempRet.put(target - nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (tempRet.containsKey(nums[i])) {
                ret[0] = tempRet.get(nums[i]);
                ret[1] = i;
            }
            tempRet.put(target - nums[i], i);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }
}
