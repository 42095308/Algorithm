package martix;

public class SolutionSearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            if (matrix[0][i] > target) continue;
            int row = 0;
            while (row < matrix.length) {
                if (matrix[row++][i] == target) {
                    return true;
                }
                if (matrix[row][i] > target) break;
            }
        }
        return false;
    }
}
