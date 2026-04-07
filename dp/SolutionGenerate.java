package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionGenerate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 每一行的首尾永远是 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> prevRow = ret.get(i - 1);
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
