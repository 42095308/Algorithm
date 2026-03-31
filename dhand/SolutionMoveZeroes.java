package dhand;

import java.util.Arrays;

public class SolutionMoveZeroes {
    public static void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int slow, fast;
        slow = fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        Arrays.fill(nums, slow, nums.length - 1, 0);
    }
}
