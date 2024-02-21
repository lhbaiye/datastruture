package org.example.daimasuixianglu.dongtaiguihua;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author chenxuyang
 * @version 1.0
 * @project untitled
 * @description
 * @date 2024/1/17 19:17:54
 */
public class leet377 {
    @Test
    public void test() {
        System.out.println(combinationSum4(new int[]{3,1,2}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
            Arrays.stream(dp).forEach(System.out::print);
            System.out.println("");
        }
        return dp[target];
    }
}
