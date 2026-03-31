package bserarch;

public class SolutionFindMin {
    public int findMin(int[] nums) {
        // 核心思想：原数组一定是旋转过的，所以最小值一定无序的那部分，且最小值点一定是顺序突变点
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) { // 表示右半部分是无序的

            } else {

            }
        }
        return -1;
    }
}
