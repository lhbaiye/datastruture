package org.example.leetcode.dongtaiguihua;

import java.util.Arrays;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/26 14:02:22
 */
public class leet322 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[i]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]  + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
