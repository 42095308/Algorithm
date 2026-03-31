package backtrace;

import java.util.ArrayList;
import java.util.List;

public class SolutionPermute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>(nums.length);
        boolean[] used = new boolean[nums.length];
        backtrace(ret, nums, path, used);
        return ret;
    }

    private void backtrace(List<List<Integer>> ret, int[] nums, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtrace(ret, nums, path, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

}
