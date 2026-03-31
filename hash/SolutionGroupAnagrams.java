package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolutionGroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> tempMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tempChar = strs[i].toCharArray();
            Arrays.sort(tempChar);
            String tempStr = new String(tempChar);
            if (!tempMap.containsKey(tempStr)) {
                tempMap.put(tempStr, new ArrayList<>());
            }
            tempMap.get(tempStr).add(strs[i]);
        }
        ArrayList<List<String>> ret = new ArrayList<>();
        for (List<String> value : tempMap.values()) {
            ret.add(value);
        }
        return ret;
    }
}
