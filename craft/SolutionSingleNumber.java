package craft;

public class SolutionSingleNumber {
    public static int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        // 核心技巧：0与任何数字进行异或都得任何数
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
    }
}
