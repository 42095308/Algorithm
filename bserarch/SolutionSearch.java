package bserarch;

public class SolutionSearch {
    public int search(int[] nums, int target) {
        // 核心思想：如果将数组随机分成两半，则有一半必定是有序的
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2; // 使用mid进行切割
            if (nums[mid] == target) return mid;
            // 判断左半部分是否有序
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && nums[mid] >= target) {
                    // 表示target在区间[l, mid]中
                    r = mid - 1; // 收缩区间
                } else {
                    // 说明target在无序的那一部分区间
                    l = mid + 1;
                }
            } else {
                if (nums[mid] <= target && nums[r] >= target) {
                    // 表示target在区间[mid, r]中
                    l = mid + 1;
                } else {
                    // 说明target在无序的那一部分区间
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
