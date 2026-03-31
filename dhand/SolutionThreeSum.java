package dhand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;

public class SolutionThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 1) {
            return ret;
        }
        Arrays.sort(nums);
        int r, l;
        for (int i = 0; i < nums.length - 2; i++) { // 外层for循环用于固定第一个元素，将其转为两数之和
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            r = i + 1; // 第二个数字
            l = nums.length - 1; // 第三个数字
            while (r < l) {
                int temp = nums[i] + nums[r] + nums[l];
                if (temp > 0) {
                    l--;
                } else if (temp < 0) {
                    r++;
                } else {
                    ret.add(Arrays.asList(nums[i], nums[r], nums[l]));
                    // 当添加完元素之后，应该使r与l直接跳到非重复元素的位置
                    r++;
                    l--;
                    while (r < l && nums[r] == nums[r-1]) r++;
                    while (r < l && nums[l] == nums[l+1]) l--;
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
