package dhand;

public class SolutionMaxArea {
    public static  int maxArea(int[] height) {
        int ret = Integer.MIN_VALUE;
        int r, l;
        r = 0;
        l = height.length - 1;
        while (r < l) {
            ret = Math.max(ret, Math.min(height[r], height[l]) * Math.abs(l - r));
            // 一开始从面积方向考虑出错。应该是从元素方向去考虑，因为两个点位固定后，间隔是确定的，因此只有当a，b越大的时候，面积才是最大的
            if (height[r] > height[l]) {
                l--;
            } else {
                r++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,3,2,5,25,24,5}));
    }
}
