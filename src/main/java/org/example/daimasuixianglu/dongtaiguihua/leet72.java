package org.example.daimasuixianglu.dongtaiguihua;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/18 22:51:15
 */
public class leet72 {
    public int minDistance(String word1, String word2) {
        int w1Len = word1.length();
        int w2Len = word2.length();
        int[][] dp = new int[w1Len + 1][w2Len + 1];
        for (int i = 0; i <= w1Len; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= w2Len; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= w1Len; i++) {
            for (int j = 1; j <= w2Len; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[w1Len][w2Len];
    }
}
