package greed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionPartitionLabels {
    /*
    * 核心思路：使用hash存储每一个字符的最后出现位置。在遍历字符串时，同时维护一个最大边界
    * */
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            cache.put(s.charAt(i), i);
        }
        List<Integer> ret = new ArrayList<>();
        int end = 0;
        int preEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            int curCharacterEnd = cache.get(s.charAt(i));
            if (curCharacterEnd > end) end = curCharacterEnd;
            if (i == end) {
                ret.add(end - preEnd + 1);
                preEnd = end + 1;
            }
        }
        return ret;
    }
}
