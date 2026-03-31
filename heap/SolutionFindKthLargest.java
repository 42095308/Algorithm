package heap;

import java.util.Random;

public class SolutionFindKthLargest {
    private final Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < 2) {
            return nums[0];
        }
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int targetIndex = len - k;
        int retIndex;
        while (true) {
            retIndex = partition(nums, l, r);
            if (retIndex == targetIndex) {
                return nums[retIndex];
            } else if (retIndex < targetIndex) {
                l = retIndex + 1; // 目标在右边，更新左边界
            } else {
                r = retIndex - 1; // 目标在左边，更新右边界
            }
        }
    }

    private int partition(int[] nums, int l, int r) {
        int randomIndex = l + random.nextInt(r - l + 1);
        int pivot = nums[randomIndex];
        swap(nums, l, randomIndex);
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[randomIndex] = pivot;
        return randomIndex;
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}
