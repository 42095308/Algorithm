package craft;

public class SolutionFindDuplicate {
    /*
    * 核心思想：将数组转为链表，如果有重复元素，则一定会成环（即先入环，在找环的起点）
    * */
    public int findDuplicate(int[] nums) {
        int slow = nums[0]; // 指向第一个元素
        int fast = nums[nums[0]]; // 指向第二个元素
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 此时找到了相遇点
        int x = 0;
        while (x != slow) {
            slow = nums[slow];
            x = nums[x];
        }
        return slow;
    }
}
