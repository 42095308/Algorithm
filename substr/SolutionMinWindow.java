package substr;

import java.util.Arrays;

public class SolutionMinWindow {
    public static String minWindow(String s, String t) {
        String ret = "";
        // 使用频率数组
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int minLen = Integer.MAX_VALUE;
        int required = Math.toIntExact(Arrays.stream(need).filter(x -> x > 0).count());
        int validated = 0;
        int[] window = new int[128];
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window[c]++;
            if (window[c] == need[c]) validated++;
            while (required == validated) {
               if (minLen > r - l + 1) {
                   ret = s.substring(l, r + 1);
                   minLen = r - l + 1;
               }
                char pre = s.charAt(l);
                window[pre]--;
                if (window[pre] < need[pre]) validated--;
                l++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "aa"));
    }
}
