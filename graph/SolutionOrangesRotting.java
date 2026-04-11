package graph;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionOrangesRotting {
    public static int orangesRotting(int[][] grid) {
        // 遍历网格找出所有的腐烂橘子（多源bfs）
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 注意：上下左右都可腐蚀
        Queue<int[]> queue = new LinkedList<>();
        int freshOrange = 0;
        int minute = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) freshOrange++;
                if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }
        if (freshOrange == 0) {
            return 0;
        }
        if (queue.isEmpty()) {
            return -1;
        }
        while (!queue.isEmpty() && freshOrange > 0) {
            int size = queue.size();
            minute++; // 开始感染minute加一
            while (size > 0) {
                int[] rottedOrange = queue.poll();
                size--;
                for (int[] dir : dirs) {
                    int nextRow = rottedOrange[0] + dir[0];
                    int nextCol = rottedOrange[1] + dir[1];
                    if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[nextRow].length && grid[nextRow][nextCol] == 1) {
                        queue.add(new int[]{nextRow, nextCol});
                        grid[nextRow][nextCol] = 2;
                        freshOrange--;
                    }
                }
            }

        }
        return freshOrange == 0 ? minute : -1;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}
