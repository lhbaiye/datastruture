package org.example.daimasuixianglu.dongtaiguihua;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/17 18:59:28
 */
public class leet518 {
    @Test
    public void test() {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        //递推表达式
        int[] dp = new int[amount + 1];
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0] = 1;
        // for (int i = 0; i < coins.length; i++) {
        //     for (int j = coins[i]; j <= amount; j++) {
        //         dp[j] += dp[j - coins[i]];
        //     }
        //     Arrays.stream(dp).forEach(System.out::print);
        //     System.out.println("");
        // }

        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            for (int i = 0; i < coins.length; i++) { // 遍历物品
                if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
            }
            Arrays.stream(dp).forEach(System.out::print);
            System.out.println("");
        }
        return dp[amount];
    }

}
