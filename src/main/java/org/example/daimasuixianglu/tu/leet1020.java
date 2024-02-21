package org.example.daimasuixianglu.tu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/19 21:52:44
 */
public class leet1020 {
    int result;
    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][grid[0].length - 1] == 1) {
                dfs(grid, i, grid[0].length - 1);
            }
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, 0, i);
            }
            if (grid[grid.length - 1][i] == 1) {
                dfs(grid, grid.length - 1, i);
            }
        }
        result = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    public void dfs(int[][] grid, int r, int c) {
        if (!isArea(grid, r, c)) {
            return;
        }
        if (grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2;
        result++;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public boolean isArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
