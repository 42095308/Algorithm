package stack;

import java.time.temporal.Temporal;
import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionDecodeString {
    // 为了防止嵌套解码：要将所有字符都入栈才行
    public static String decodeString(String s) {
        StringBuilder ret = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') stack.push(c);
            else {
                // 遇到 ] 开始解析栈中的元素
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp.insert(0, stack.pop());
                }
                stack.pop(); // 将 [ 弹出
                // 开始解析数字
                int count = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    count += (stack.pop() - '0') * base;
                    base *= 10;
                }
                // 将字符重新入栈
                for (int j = 0; j < count; j++) {
                    for (int k = 0; k < temp.length(); k++) {
                        stack.push(temp.charAt(k));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            ret.insert(0, stack.pop());
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}
