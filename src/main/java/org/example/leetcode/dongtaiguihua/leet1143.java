package org.example.leetcode.dongtaiguihua;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/26 13:32:38
 */
public class leet1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int text1Len = text1.length();
        int text2Len = text2.length();
        int[][] dp = new int[text1Len + 1][text2Len + 1];
        for (int i = 1; i <= text1Len; i++) {
            for (int j = 1; j <= text2Len; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
