package martix;

public class SolutionRotate {
    public void rotate(int[][] matrix) {
        if (matrix.length == 1) return;
        // 转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 翻转
        for (int j = 0; j < matrix.length / 2; j++) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
