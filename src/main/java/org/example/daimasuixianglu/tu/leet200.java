package org.example.daimasuixianglu.tu;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * @date 2024/1/19 20:35:32
 */
public class leet200 {
    public int numIslands(char[][] grid) {
        int res = 0; //记录找到的岛屿数量
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                //找到“1”，res加一，同时淹没这个岛
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (!isArea(grid, r, c)) {
            return;
        }
        if (grid[r][c] != '1') {
            return;
        }
        grid[r][c] = 2;
        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    //使用DFS“淹没”岛屿

    public boolean isArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
