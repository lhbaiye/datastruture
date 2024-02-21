package org.example.daimasuixianglu.tu;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/19 21:41:47
 */
public class leet695dfs {
    int count;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j <grid[0].length; j++) {
                if(grid[i][j] == 1){
                    int a = bfs(grid, i, j);
                    res = Math.max(res, a);
                }
            }
        }
        return res;

    }

    private int bfs(int[][] grid, int r, int c) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        grid[r][c] = 2;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.pop();
            int m = cur[0];
            int n = cur[1];
            if (isArea(grid, m, n + 1)) {
                queue.add(new int[]{m, n+1});
                grid[m][n+1] = 2;
                count++;
            }
            if (isArea(grid, m, n - 1)) {
                queue.add(new int[]{m, n-1});
                grid[m][n-1] = 2;
                count++;
            }
            if (isArea(grid, m - 1, n)) {
                queue.add(new int[]{m - 1, n});
                grid[m-1][n] = 2;
                count++;
            }
            if (isArea(grid, m+1, n)) {
                queue.add(new int[]{m+1, n});
                grid[m+1][n] = 2;
                count++;
            }
        }
        return count;
    }

    public boolean isArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 1;
    }
}
