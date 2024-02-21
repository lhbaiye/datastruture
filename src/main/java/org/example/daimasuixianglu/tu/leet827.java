package org.example.daimasuixianglu.tu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/20 15:01:26
 */
public class leet827 {
    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 1;
        }
        int size = grid.length;
        int res = 0;
        int index = 2;
        HashMap<Integer, Integer> indexAndAreas = new HashMap<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c, index);
                    indexAndAreas.put(index, area);
                    index++;
                    res = Math.max(res, area);
                }
            }
        }
        if (res == 0) {
            return 1;
        }
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] != 0) {
                    continue;
                }
                int curSize = 1;
                Set<Integer> hashSet = new HashSet<>();
                for (int[] current: position) {
                    int curRow = row + current[0], curCol = col + current[1];
                    if(!isArea(grid, curRow, curCol)) {
                        continue;
                    }
                    int curMark = grid[curRow][curCol];     // 获取对应位置的标记
                    // 如果标记存在 hashSet 中说明该标记被记录过一次，如果不存在 getSize 中说明该标记是无效标记(此时 curMark = 0)
                    if (hashSet.contains(curMark) || !indexAndAreas.containsKey(curMark)) {
                        continue;
                    }
                    hashSet.add(curMark);
                    curSize += indexAndAreas.get(curMark);
                }
                res = Math.max(res, curSize);
            }
        }
        return res == Integer.MIN_VALUE ? size * size : res;

    }

    public int dfs(int[][] grid, int row, int col, int mark) {
        int ans = 1;
        grid[row][col] = mark;

        for (int[] current : position) {
            int curRow = row + current[0], curCol = col + current[1];
            if (!isArea(grid, curRow, curCol)) {
                continue;
            }
            if (grid[curRow][curCol] == 1) {
                ans += dfs(grid, curRow, curCol, mark);
            }
        }
        return ans;
    }

    public boolean isArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
