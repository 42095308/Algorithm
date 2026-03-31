package backtrace;

import java.util.ArrayList;
import java.util.List;

public class SolutionLetterCombinations {
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        char[] path = new char[digits.length()];
        int startIndex = 0;
        backtrace(ret, path, startIndex, digits);
        return ret;
    }

    private static void backtrace(List<String> ret, char[] path, int startIndex, String digits) {
        if (startIndex == digits.length()) {
            ret.add(new String(path));
            return;
        }
        // 获取当前层需要遍历的字符串
        String target = MAPPING[digits.charAt(startIndex) - '0'];
        for (char c : target.toCharArray()) {
            path[startIndex] = c;
            backtrace(ret, path, startIndex + 1, digits);
            // 不用已出path中的数据，会被直接覆盖
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }

}
