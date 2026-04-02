package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionLargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        // 解题思路：使用单调栈，单调递增栈。矩形的面积取决于最短的矩形高度，所以当碰到一个短的矩形高度时就表示到了最小的面积。
        // 由于栈中最后可能会有元素，所以引入一个末尾哨兵。
        // 由于可能会存在一个元素位于数组中间且他是最小的，所以需要一个首位哨兵。
        int[] temp = new int[heights.length + 2];
        System.arraycopy(heights, 0, temp, 1, heights.length);
        Deque<Integer> stack = new ArrayDeque<>(temp.length);
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] > temp[i]) { // 遇到右边界，可以存入重复元素，否则可能会导致哨兵元素被弹出栈
                // 左边界一定是栈的前一个元素
                int curIndex = stack.pop();
                // 不需要判断栈是否为空，因为有哨兵存在
                int peekIndex = stack.peek(); // 左边界
                int w = i - peekIndex - 1; // 这就是触发延迟计算的核心（当弹出一个元素后，如果下一个元素依然大于当前遍历的元素，i是不变的，也就表示下一个元素的宽度要增加，因为比他高的元素被弹出了）
                ret = Math.max(ret, w * temp[curIndex]);
            }
            stack.push(i);
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
