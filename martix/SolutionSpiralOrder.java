package martix;

import java.util.ArrayList;
import java.util.List;

public class SolutionSpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 使用四指针法
        ArrayList<Integer> ret = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            // 遍历顺序：右→下→左→上
            for (int i = left; i <= right; i++) {
                ret.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ret.add(matrix[i][right]);
            }
            right--;
            // 此时需要判断。有可能原矩阵是一个单例或单行矩阵
            if (left <= right && top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ret.add(matrix[bottom][i]);
                }
            }
            bottom--;
            if (left <= right && top <= bottom) {
                for (int i = bottom; i >= top; i--) {
                    ret.add(matrix[i][left]);
                }
            }
            left++;
        }
        return ret;
    }
}
