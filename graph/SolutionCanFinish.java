package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionCanFinish {
    /*
    * 本题的本质是有向图判环（拓扑排序，入度法）
    * numCourses：表示是否可以成功访问numCourses个节点
    * prerequisites：邻接矩阵形式的有向图
    * */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        // 创建邻接表以及统计入度
        int[] indegrees = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0]; // 这是终点
            int b = prerequisite[1]; // 这是起点
            graph.get(b).add(a); // 构建邻接表
            indegrees[a]++;
        }
        // 将所有入度为0的节点加入队列，出队的时候，删除终点的入度，直到队列中没有节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i); // 入度为0的节点都是起点
        }
        while (!queue.isEmpty()) {
            // 弹出起点
            int start = queue.poll();
            count++;
            // 删除该起点对应的入度
            List<Integer> list = graph.get(start); // 该起点对应的所有终点
            for (int i = 0; i < list.size(); i++) {
                indegrees[list.get(i)]--;
                if (indegrees[list.get(i)] == 0) queue.add(list.get(i));
            }
        }
        return numCourses == count;
    }
}
