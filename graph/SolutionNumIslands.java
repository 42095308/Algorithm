package graph;

public class SolutionNumIslands {
    /*
    * 本体思路：有点像dfs的判环过程（单源多次）
    * 核心思路：每次遇见一个'1'就将其变为0，然后计数器加一
    * */
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, dirs, i, j); // dfs过程：遍历以当前节点为入口的所有'1'
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int [][] dirs, int row, int col) {
        grid[row][col] = '0';
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[newRow].length && grid[newRow][newCol] == '1' ) {
                dfs(grid, dirs, newRow, newCol);
            }
        }
    }
}
