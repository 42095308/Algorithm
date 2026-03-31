package dhand;

import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionTrap {
    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int ans = 0;
        // 使用单调栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty()) {
                if (height[stack.peek()] > height[i]) {
                    break;
                }
                int temp = stack.pop();
                if (stack.isEmpty()) { // 判断是否还有底
                    break;
                }
                ans += (Math.min(height[stack.peek()], height[i]) - height[temp]) * (i - stack.peek() - 1);
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }
}
