package bserarch;

public class SolutionFindMedianSortedArrays {
    /*
    * 核心思想：就是对两个数组进行切割，需要保证交叉验证通过（L1<=R2, L2<=R1）
    * [ 2, 3, 5, 8 | 10, 12 ]   L1 = 8, R1 = 10
    * [ 1, 4, 7, 9 | 11, 13, 14, 15, 16, 17 ]   L2 = 9, R2 = 11
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 需要保证每次切割在小数组上进行
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = nums1.length;
        int m = nums2.length;
        int l = 0;
        int r = n;
        int leftTotal = l + (r - l + 1) / 2; // +1是为了保证每次取数小数组都参与
        while (l <= r) { // 如果是l < r，则会漏掉l==r位置的左右两个切口
            int i = l + (r - l) / 2;
            int j = leftTotal - i; // 右边的数组需要给左边的数组补多少个元素
            // 处理第一个与最后一个切割位置为空的情况
            int L1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int R1 = (i == n) ? Integer.MAX_VALUE : nums1[i];
            int L2 = (i == 0) ? Integer.MIN_VALUE : nums1[j - 1];
            int R2 = (i == n) ? Integer.MAX_VALUE : nums1[j];
            // 判断切割位置是否满足切割条件
            if (L1 <= R2 && L2 <= R1) {
                // 切割位置正确
                if ((m + n) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.max(L1, L2);
                }
            } else if (L1 > R2) {
                // 说明小数组的切割位置太靠后了（数组是升序排列）
                r = i - 1;
            } else if (L2 > R1) {
                // 说明小数组的切割位置太靠前了
                l = i + 1;
            }
        }
        return 0.0;
    }
}
