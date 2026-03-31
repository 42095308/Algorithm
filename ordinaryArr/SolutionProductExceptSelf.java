package ordinaryArr;

import java.util.Arrays;

public class SolutionProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        if (nums.length == 1) {
            return new int[]{nums[0]};
        }
        // 使用空间换时间：使用两个乘积数组
        int[] ans = new int[nums.length];
        int[] preMul = new int[nums.length];
        int[] sufMul = new int[nums.length];
        Arrays.fill(preMul, 1);
        Arrays.fill(sufMul, 1);
        for (int i = 1; i < nums.length; i++) {
            preMul[i] = preMul[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            sufMul[i] = sufMul[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = preMul[i] * sufMul[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
