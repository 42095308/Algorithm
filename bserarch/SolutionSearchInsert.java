package bserarch;

public class SolutionSearchInsert {
    public static int searchInsert(int[] nums, int target) {
        // 注意：无重复+已排序
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) { // l==r时，一定可以保证出循环时，l在r的右边。对于边界的判断可以使用特殊值法确定
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] == target) return mid;
        }
        // 为什么l一定是待插入的位置呢？而不是r呢？
        /*
        * 因为逻辑是当nums[mid] < target时，l是一直在向前走的
        * 即假设当nums[mid] == target时，跳出循环后l一定是大于mid的。而r一定是小于mid的
        * */
        return l;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
    }
}
