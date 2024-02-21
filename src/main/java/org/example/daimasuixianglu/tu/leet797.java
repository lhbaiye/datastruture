package org.example.daimasuixianglu.tu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/19 20:12:14
 */
public class leet797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, result, path, 0);
        return result;
    }

    private void dfs(int[][] graph, List<List<Integer>> result, List<Integer> path, int index) {
        if (index == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[index].length; i++) {
            path.add(graph[index][i]);
            dfs(graph, result, path, graph[index][i]);
            path.remove(path.size() - 1);
        }
    }
}
