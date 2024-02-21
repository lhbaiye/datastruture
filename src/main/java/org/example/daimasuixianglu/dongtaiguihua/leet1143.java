package org.example.daimasuixianglu.dongtaiguihua;

import org.junit.Test;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/18 14:26:49
 */
public class leet1143 {

    @Test
    public void test() {
        longestCommonSubsequence("abcde", "ace");
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int s1Len = text1.length();
        int s2Len = text2.length();
        char[] t1Array = text1.toCharArray();
        char[] t2Array = text2.toCharArray();
        int[][] dp = new int[s1Len + 1][s2Len + 1];
        for (int i = 1; i <= s1Len; i++) {
            for (int j = 1; j <= s2Len; j++) {
                if (t1Array[i- 1] == t2Array[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
