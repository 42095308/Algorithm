package slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionFindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        // 这种字符串相关的滑动窗口类的题目都可以使用频率数组进行求解
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ret = new ArrayList<>(s.length() - p.length() + 1);
        int[] need = new int[128];
        for (char c : p.toCharArray()) {
            need[c]++;
        }
        // 非重复的字符个数
        int required = Math.toIntExact(Arrays.stream(need).filter(x -> x > 0).count());
        int[] window = new int[128];
        int validated = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window[c]++;
            if (window[c] == need[c]) validated++;
            if (r - l < p.length() - 1) continue;
            if (validated == required) {
                ret.add(l);
            }
            char pre = s.charAt(l);
            if (window[pre] == need[pre]) validated--;
            window[pre]--;
            l++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
