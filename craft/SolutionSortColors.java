package craft;

import java.awt.font.NumericShaper;

public class SolutionSortColors {
    /*
     * 荷兰国旗问题：三指针方法
     * */
    public static void sortColors(int[] nums) {
        int left = 0; // 表示0应该插入的位置
        int right = nums.length - 1; // 表示2应该插入的位置
        /*
         * 整个区间被分为四个区域
         * [0, left - 1] : 这是0的区域
         * [left, i - 1] : 这是1的区域
         * [i, right] : 这是未知区域
         * [right + 1, nums.length - 1] : 这是2的区域
         * */
        int i = 0;
        while (i <= right) {
            if (nums[i] == 2) {
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
            } else if (nums[i] == 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
                // nums[i] == 0时需要i++，因为前面区域中的数字都是安全的， 而i与right区域都是未知的，所以nums[i] == 2时不能i++
                i++;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
