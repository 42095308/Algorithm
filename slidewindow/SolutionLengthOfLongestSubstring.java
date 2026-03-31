package slidewindow;

import java.util.HashMap;

public class SolutionLengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        // 统计不重复字串的最大长度（滑动窗口，使用频率数组）
        int ret = 0;
        int left = 0;
        int[] f = new int[128];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            f[c]++; // 右边扩大窗口
            while (f[c] > 1) { // 从左向右逐个剔除，直到没有相同字符
                f[charArray[left]]--;
                left++;
            }
            ret = Math.max(ret, i - left + 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
