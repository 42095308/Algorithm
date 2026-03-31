package ordinaryArr;

public class SolutionFirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        // 将普通数组直接转为hash数组（将数组中的元素直接移动到对应的位置下）
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                // swap
                int t1 = nums[i];
                int t2 = nums[t1 - 1];
                nums[t1 - 1] = t1;
                nums[i] = t2;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
