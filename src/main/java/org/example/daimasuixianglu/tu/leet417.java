package org.example.daimasuixianglu.tu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/20 13:43:27
 */
public class leet417 {

    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowSize = heights.length, colSize = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        // 记录 [row, col] 位置是否可以到某条河，可以为 true，反之为 false；
        // 假设太平洋的标记为 1，大西洋为 0
        boolean[][][] visited = new boolean[rowSize][colSize][2];
        for (int row = 0; row < rowSize; row++) {
            visited[row][colSize - 1][0] = true;
            visited[row][0][1] = true;
            dfs(heights, row, colSize - 1, 0, visited);
            dfs(heights, row, 0, 1, visited);
        }
        for (int col = 0; col < colSize; col++) {
            visited[rowSize - 1][col][0] = true;
            visited[0][col][1] = true;
            dfs(heights, rowSize - 1, col, 0, visited);
            dfs(heights, 0, col, 1, visited);
        }
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                // 如果该位置即可以到太平洋又可以到大西洋，就放入答案数组
                if (visited[row][col][0] && visited[row][col][1])
                    ans.add(List.of(row, col));
            }
        }
        return ans;
    }

    private void dfs(int[][] heights, int row, int col, int sign, boolean[][][] visited) {
        for (int[] current : position) {
            int curRow = row + current[0], curCol = col + current[1];
            if (!isArea(heights, curRow, curCol)) {
                continue;
            }
            if (heights[row][col] > heights[curRow][curCol] || visited[curRow][curCol][sign]) {
                continue;
            }
            visited[curRow][curCol][sign] = true;
            dfs(heights, curRow, curCol, sign, visited);

        }
    }

    public boolean isArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
