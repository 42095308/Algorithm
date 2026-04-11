package craft;

public class SolutionNextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int r = nums.length - 1;
        while (r > 0) {
            int preV = nums[r - 1];
            if (preV >= nums[r]) {
                r--;
            } else {
                break;
            }
        }
        if (r == 0) {
            // 数组就是降序排序
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // 已找到突变点
        int changeIndex = r - 1;
        int changeValue = nums[changeIndex];
        r = nums.length - 1;
        // 寻找大于突变点处元素的下标
        while (r > 0 && nums[r] <= changeValue) r--;
        // 交换突变点处元素与刚好大于该突变点元素对应的元素
        int temp = nums[r];
        nums[r] = changeValue;
        nums[changeIndex] = temp;
        // 对突变点后面的元素进行翻转（将其转为升序）
        int start = changeIndex + 1;
        int end = nums.length - 1;
        reverse(nums, start, end);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
