package bserarch;

public class SolutionFindMin {
    public static int findMin(int[] nums) {
        // 核心思想：原数组一定是旋转过的，所以最小值一定无序的那部分，且最小值点一定是顺序突变点
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while (l < r) { // l不能等于r，如果是相等的话，出循环时，就会跳过最小值
            mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) { // 表示右半部分是无序的
                // mid位置肯定不是最小值
                l = mid + 1;
            } else {
                // 左半部分是无序的（对于左半部分来说mid位置处可能是最小值处）
                r = mid;
            }
        }
        return nums[l];
    }


    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
}
