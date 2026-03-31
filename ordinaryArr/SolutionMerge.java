package ordinaryArr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionMerge {
    public static int[][] merge(int[][] intervals) {
        // 需要从左端点进行遍历，这样才能保证是一个连续的数组，如果从右端点进行遍历
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        List<int[]> ans = new ArrayList<>();
        for (int[] arr : intervals) {
            int m = ans.size();
            if (m > 0 && ans.get(m - 1)[1] >= arr[0]) {
                ans.get(m - 1)[1] = Math.max(arr[1], ans.get(m - 1)[1]);
            } else {
                ans.add(arr);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
