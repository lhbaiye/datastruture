package org.example.leetcode.dongtaiguihua;

import java.util.List;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/25 19:07:52
 */
public class leet120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] saves = new int[triangle.size()][triangle.size()];
        return dfs(0, 0, triangle, saves);
    }

    private int dfs(int x, int y, List<List<Integer>> triangle, int[][] saves) {
        if (x == triangle.size() - 1) {
            return triangle.get(x).get(y);
        }
        if (saves[x][y] != 0) {
            return saves[x][y];
        }
        int leftMin = dfs(x + 1, y, triangle, saves);
        int rightMin = dfs(x + 1, y + 1, triangle, saves);
        saves[x][y] = Math.min(leftMin, rightMin) + triangle.get(x).get(y);
        return saves[x][y];
    }

    private int dfs2(int x, int y, List<List<Integer>> triangle) {
        if (x == triangle.size() - 1) {
            return triangle.get(x).get(y);
        }
        // 左边最小的
        int leftMin = dfs2(x + 1, y, triangle);
        int rightMin = dfs2(x + 1, y + 1, triangle);
        return Math.min(leftMin, rightMin) + triangle.get(x).get(y);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        // 从最后一层中查找最小值
        int minValue = dp[triangle.size() - 1][0];
        for (int i = 0; i < triangle.size(); i++) {
            minValue = Math.min(minValue, dp[triangle.size() - 1][i]);
        }
        return minValue;

    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        // 自底向上
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }
        // 然后考虑倒数第二层
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
