package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SolutionCombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 首先对数组元素进行排序，以便后续递归时对其进行剪枝操作
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        if (target < candidates[0]) {
            return ret;
        }
        int curSum = 0;
        int startIndex = 0; // 引入每次递归的起始下标，预防重复解集
        List<Integer> path = new ArrayList<>();
        backtrace(ret, path, candidates, curSum, target, startIndex);
        return ret;
    }

    private static void backtrace(List<List<Integer>> ret, List<Integer> path, int[] candidates, int curSum, int target, int startIndex) {
        if (target == curSum) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (curSum + candidates[i] > target) break;
            curSum += candidates[i];
            path.add(candidates[i]);
            // startIndex处传入i，可以起到只有满足条件时才会继续从当前位置开始递归，而不满足时，就会向下走，不会走回头路
            backtrace(ret, path, candidates, curSum, target, i);
            curSum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
