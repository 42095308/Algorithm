package backtrace;

import java.util.ArrayList;
import java.util.List;

public class SolutionPartition {
    public List<List<String>> partition(String s) {
        // 注意：长度为n的串，有n-1个切割位置
        List<List<String>> ret = new ArrayList<>();
        List<String> path = new ArrayList<>();
        if (s.length() == 1) {
            path.add(s);
            ret.add(path);
            return ret;
        }
        int startIndex = 0;
        backtrace(s, startIndex, ret, path);
        return ret;
    }

    private void backtrace(String s, int startIndex, List<List<String>> ret, List<String> path) {
        if (startIndex >= s.length()) { // 从0开始切割
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (check(s.substring(startIndex, i + 1))) {
                path.add(s.substring(startIndex, i + 1)); // 第一层先切第一个字母，第二层切两个字母
                backtrace(s, i + 1, ret, path); // 递归向下切上一层剩下的字母
                path.remove(path.size() - 1);
            }
        }
    }

    /*
    * 检查是否是回文串
    * */
    private boolean check(String temp) {
        int l = 0;
        int r = temp.length() - 1;
        if (l > r) return false;
        while (l <= r) {
            if (temp.charAt(l) != temp.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
