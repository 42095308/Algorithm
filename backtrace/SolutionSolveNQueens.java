package backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionSolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        // 对棋盘进行初始化
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> ret = new ArrayList<>();
        int located = 0;
        backtrace(ret, board, located, n, 0);
        return ret;
    }

    private void backtrace(List<List<String>> ret, char[][] board, int located, int n, int row) {
        if (located == n) {
            List<String> path = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                path.add(new String(board[i]));
            }
            ret.add(path);
            return;
        }
        // 通过循环遍历每一个列
        for (int col = 0; col < n; col++) {
            if (check(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrace(ret, board, located + 1, n, row + 1);
                board[row][col] = '.';
            }
        }
    }

    /*
    * 用于判断当前位置是否符合n皇后的规则
    * 注意：行每次都是递增的，所以不需要判断同行是否有皇后
    * */
    private boolean check(char[][] board, int row, int col, int n) {
        // 判断列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // 判断斜线
        for (int i = 1; i <= row; i++) {
            if (col - i >= 0)
                if (board[row - i][col - i] == 'Q') return false;
            if (col + i < n)
                if (board[row - i][col + i] == 'Q') return false;
        }
        return true;
    }
}
