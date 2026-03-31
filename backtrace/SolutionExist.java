package backtrace;

import java.util.Arrays;

public class SolutionExist {
    // 思路：使用方向数组+搜索起点
    // 注意：格子不能被重复访问，因此需要一个used数组
    private final int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int[][] used = new int[board.length][board[0].length];
        boolean flag = false;
        int curRow = 0;
        int curCol = 0;
        int located = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    curRow = i;
                    curCol = j;
                    located++;
                    flag = backtrace(board, word, curRow, curCol, used, located);
                    if (flag) return flag;
                    located--;
                }
            }
        }
        return flag;
    }

    private boolean backtrace(char[][] board, String word, int curRow, int curCol, int[][] used, int located) {
        if (located == word.length() - 1) return true;
        used[curRow][curCol] = 1;
        for (int[] dir : dirs) {
            int nextRow = curRow + dir[0];
            int nextCol = curCol + dir[1];
            if (nextRow >= 0 && nextRow < board.length &&
                    nextCol >= 0 && nextCol < board[0].length &&
                    used[nextRow][nextCol] == 0 &&
                    board[nextRow][nextCol] == word.charAt(located + 1)) {
                if (backtrace(board, word, nextRow, nextCol, used, located + 1)) return true;
            }
        }
        used[curRow][curCol] = 0;
        return false;
    }
}
