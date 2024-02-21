package org.example.daimasuixianglu.dongtaiguihua;

import org.junit.Test;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/18 12:03:35
 */
public class leet121 {
    @Test
    public void test() {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // 0持有 1 不持有
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][0]);
    }

    public int maxProfit1(int[] prices) {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = dp[0];
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], temp + prices[i]);
        }
        return dp[1];
    }
}
