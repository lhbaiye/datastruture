package org.example.leetcode.dongtaiguihua;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2023/12/26 14:40:35
 */
public class leet518 {
    public int change(int amount, int[] coins) {
        // 状态 dp[i]表示金额为i时，组合的方法数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i]+=dp[i - coin];
                }
            }
        }
        return 1;
    }
}
