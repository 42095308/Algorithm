package backtrace;

import java.util.ArrayList;
import java.util.List;

public class SolutionGenerateParenthesis {
    // 本题目的核心思想（两条准则）：应该以谁为基准进行遍历，遍历的过程中如何确保每次加入的括号是合法的。
    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if (n == 1) {
            ret.add("()");
            return ret;
        }
        StringBuilder path = new StringBuilder();
        int leftParenthesis = 0;
        int rightParenthesis = 0;
        backtrace(ret, path, n, leftParenthesis, rightParenthesis);
        return ret;
    }

    private static void backtrace(List<String> ret, StringBuilder path, int n, int leftParenthesis, int rightParenthesis) {
        if (path.length() == 2 * n) {
            ret.add(new String(path));
            return;
        }
        // 第一条准则：每次先放左括号
        if (leftParenthesis < n) {
            path.append('(');
            backtrace(ret, path, n, leftParenthesis + 1, rightParenthesis);
            path.deleteCharAt(path.length() - 1);
        }
        // 第二条准则：右括号数量必须小于左括号
        if (rightParenthesis < leftParenthesis) {
            path.append(')');
            backtrace(ret, path, n, leftParenthesis, rightParenthesis + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
