package bserarch;

import java.util.Arrays;

public class SolutionSearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        if (nums.length < 1) return ret;
        // 注意：数组有序
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        boolean flag = false;
        while (l <= r) { // l==r时，一定可以保证出循环时，l在r的右边。对于边界的判断可以使用特殊值法确定
            mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] == target) {
                flag = true;
                break;
            };
        }
        if (flag) {
            l = mid;
            r = mid;
            while (l >= 0 && nums[l] == target) l--;
            while (r < nums.length && nums[r] == target) r++;
            ret[0] = l + 1;
            ret[1] = r - 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}
